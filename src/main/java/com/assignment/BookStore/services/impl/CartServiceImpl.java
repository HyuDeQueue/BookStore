package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.CartRequestDTO;
import com.assignment.BookStore.dtos.requests.OrderRequestDTO;
import com.assignment.BookStore.dtos.responses.CartResponseDTO;
import com.assignment.BookStore.entities.Cart;
import com.assignment.BookStore.entities.OrderDetail;
import com.assignment.BookStore.repositories.CartRepository;
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
    private CartRepository cartRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private final PayOS payOS;

    @Override
    public CartResponseDTO addToCart(String userId, String bookId) {
        Optional<Cart> existingCart = cartRepository.findById(userId);
        Cart cart;

        if (existingCart.isPresent()) {
            cart = existingCart.get();
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
        } else {
            cart = new Cart();
            cart.setUserId(userId);
            cart.setOrderDetails(List.of(new OrderDetail(bookId, 1, null)));
        }

        cartRepository.save(cart);
        return CartResponseDTO.toDto(cart);
    }

    @Override
    public CartResponseDTO removeFromCart(String userId, String bookId) {
        Optional<Cart> existingCart = cartRepository.findById(userId);

        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            List<OrderDetail> orderDetails = cart.getOrderDetails();

            orderDetails.removeIf(detail -> detail.getBookId().equals(bookId));
            cart.setOrderDetails(orderDetails);
            cartRepository.save(cart);
            return CartResponseDTO.toDto(cart);
        }

        return null;
    }

    @Override
    public CartResponseDTO getCart(String userId) {
        Cart existingCart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User cart was not created, please put something inside"));
        return CartResponseDTO.toDto(existingCart);
    }

    @Override
    public void clearCart(String userId) {
        Optional<Cart> existingCart = cartRepository.findById(userId);

        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            cart.setOrderDetails(List.of());
            cartRepository.save(cart);
            CartResponseDTO.toDto(cart);
        }

    }

    @Override
    public CartResponseDTO updateCart(String userId, String bookId, Integer quantity) {
        Optional<Cart> existingCart = cartRepository.findById(userId);

        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
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

        return null;
    }

    @Override
    public CheckoutResponseData initiateCheckout(String userId, CartRequestDTO cartRequestDTO) throws Exception {
        Optional<Cart> existingCart = cartRepository.findById(userId);

        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            List<OrderDetail> currentOrderDetails = cart.getOrderDetails();
            List<OrderDetail> checkoutOrderDetails = cartRequestDTO.getOrderDetails();

            // Calculate total price
            int totalPrice = checkoutOrderDetails.stream()
                    .mapToInt(toCheckout -> toCheckout.getPrice() * toCheckout.getQuantity())
                    .sum();

            // Generate payment data
            final String description = "Thanh toán đơn hàng";
            final String returnUrl = "http://localhost:3000/payment/success";
            final String cancelUrl = "http://localhost:3000/payment/cancel";
            String currentTimeString = String.valueOf(new Date().getTime());
            long orderCode = Long.parseLong(currentTimeString.substring(currentTimeString.length() - 6));

            PaymentData paymentData = PaymentData.builder()
                    .orderCode(orderCode)
                    .description(description)
                    .amount(totalPrice)
                    .returnUrl(returnUrl)
                    .cancelUrl(cancelUrl)
                    .build();

            return payOS.createPaymentLink(paymentData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart is invalid");
        }
    }

    @Override
    public void processPostPayment(String userId, List<OrderDetail> checkoutOrderDetails) {
        Optional<Cart> existingCart = cartRepository.findById(userId);

        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            List<OrderDetail> currentOrderDetails = cart.getOrderDetails();

            List<OrderDetail> remainingOrderDetails = currentOrderDetails.stream()
                    .filter(detail -> checkoutOrderDetails.stream()
                            .noneMatch(toCheckout -> toCheckout.getBookId().equals(detail.getBookId())))
                    .collect(Collectors.toList());

            cart.setOrderDetails(remainingOrderDetails);
            cartRepository.save(cart);

            // Create order
            OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
            orderRequestDTO.setUserId(userId);
            orderRequestDTO.setOrderDetails(checkoutOrderDetails);
            orderService.createOrder(orderRequestDTO);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart is invalid");
        }
    }

}
