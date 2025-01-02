package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.CartRequestDTO;
import com.assignment.BookStore.dtos.requests.OrderRequestDTO;
import com.assignment.BookStore.dtos.responses.BookResponseDTO;
import com.assignment.BookStore.dtos.responses.CartResponseDTO;
import com.assignment.BookStore.entities.Book;
import com.assignment.BookStore.entities.Cart;
import com.assignment.BookStore.entities.OrderDetail;
import com.assignment.BookStore.repositories.CartRepository;
import com.assignment.BookStore.services.BookService;
import com.assignment.BookStore.services.CartService;
import com.assignment.BookStore.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vn.payos.PayOS;
import vn.payos.type.CheckoutResponseData;
import vn.payos.type.PaymentData;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    private BookService bookService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private final PayOS payOS;

    @Override
    public CartResponseDTO addToCart(String userId, String bookId) {
        Boolean exists = cartRepository.existsByUserId(userId);
        if (!exists) {
            Cart cart = new Cart();
            cart.setUserId(userId);
            BookResponseDTO book = bookService.getBookById(bookId);
            cart.setOrderDetails(List.of(new OrderDetail(bookId, 1, book.getCurrentPrice())));
            cartRepository.save(cart);
        }
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        List<OrderDetail> orderDetails = cart.getOrderDetails();
        boolean updated = false;

        for (OrderDetail detail : orderDetails) {
            if (detail.getBookId().equals(bookId)) {
                detail.setQuantity(detail.getQuantity() + 1);
                updated = true;
                break;
            }
        }

        if (!updated) {
            orderDetails.add(new OrderDetail(bookId, 1, null));
        }

        cart.setOrderDetails(orderDetails);
        cartRepository.save(cart);
        return CartResponseDTO.toDto(cart);
    }

    @Override
    public CartResponseDTO removeFromCart(String userId, String bookId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        List<OrderDetail> orderDetails = cart.getOrderDetails();
        orderDetails.removeIf(detail -> detail.getBookId().equals(bookId));

        cart.setOrderDetails(orderDetails);
        cartRepository.save(cart);
        return CartResponseDTO.toDto(cart);
    }

    @Override
    public CartResponseDTO getCart(String userId) {
        Boolean exists = cartRepository.existsByUserId(userId);
        if (!exists) {
            Cart cart = new Cart();
            cart.setUserId(userId);
            cartRepository.save(cart);
        }
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));
        return CartResponseDTO.toDto(cart);
    }

    @Override
    public void clearCart(String userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        cart.setOrderDetails(List.of());
        cartRepository.save(cart);
    }

    @Override
    public CartResponseDTO updateCart(String userId, String bookId, Integer quantity) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        List<OrderDetail> orderDetails = cart.getOrderDetails();
        for (OrderDetail detail : orderDetails) {
            if (detail.getBookId().equals(bookId)) {
                detail.setQuantity(quantity);
                break;
            }
        }

        cartRepository.save(cart);
        return CartResponseDTO.toDto(cart);
    }

    @Override
    public CheckoutResponseData initiateCheckout(String userId, CartRequestDTO cartRequestDTO) throws Exception {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        List<OrderDetail> checkoutOrderDetails = cartRequestDTO.getOrderDetails();
        int totalPrice = checkoutOrderDetails.stream()
                .mapToInt(detail -> detail.getPrice() * detail.getQuantity())
                .sum();

        PaymentData paymentData = PaymentData.builder()
                .orderCode(System.currentTimeMillis())
                .description("Thanh toán đơn hàng")
                .amount(totalPrice)
                .returnUrl("http://localhost:3000/payment/success")
                .cancelUrl("http://localhost:3000/payment/cancel")
                .build();

        return payOS.createPaymentLink(paymentData);
    }

    @Override
    public void processPostPayment(String userId, List<OrderDetail> checkoutOrderDetails) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        List<OrderDetail> remainingOrderDetails = cart.getOrderDetails().stream()
                .filter(detail -> checkoutOrderDetails.stream()
                        .noneMatch(toCheckout -> toCheckout.getBookId().equals(detail.getBookId())))
                .collect(Collectors.toList());

        cart.setOrderDetails(remainingOrderDetails);
        cartRepository.save(cart);

//        OrderRequestDTO orderRequestDTO = new OrderRequestDTO(userId, checkoutOrderDetails);
//        orderService.createOrder(orderRequestDTO);
    }
}
