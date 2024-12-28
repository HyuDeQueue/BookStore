package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.CartRequestDTO;
import com.assignment.BookStore.dtos.responses.CartResponseDTO;
import com.assignment.BookStore.entities.Cart;
import com.assignment.BookStore.entities.OrderDetail;
import com.assignment.BookStore.repositories.CartRepository;
import com.assignment.BookStore.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

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
        Optional<Cart> existingCart = cartRepository.findById(userId);

        return existingCart.map(CartResponseDTO::toDto).orElse(null);
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
    public void checkout(String userId, CartRequestDTO cartRequestDTO) {
        Optional<Cart> existingCart = cartRepository.findById(userId);

        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            List<OrderDetail> currentOrderDetails = cart.getOrderDetails();
            List<OrderDetail> checkoutOrderDetails = cartRequestDTO.getOrderDetails();

            List<OrderDetail> remainingOrderDetails = currentOrderDetails.stream()
                    .filter(detail -> checkoutOrderDetails.stream().noneMatch(toCheckout -> toCheckout.getBookId().equals(detail.getBookId())))
                    .collect(Collectors.toList());
//Function not finished here
            cart.setOrderDetails(remainingOrderDetails);
            cartRepository.save(cart);
        }
    }
}
