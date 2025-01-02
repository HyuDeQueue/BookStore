package com.assignment.BookStore.services;

import com.assignment.BookStore.dtos.requests.CartRequestDTO;
import com.assignment.BookStore.dtos.responses.CartResponseDTO;
import com.assignment.BookStore.entities.OrderDetail;
import vn.payos.type.CheckoutResponseData;

import java.util.List;


public interface CartService {
    public CartResponseDTO addToCart(String userId, String bookId);

    public CartResponseDTO removeFromCart(String userId, String bookId);

    public List<CartResponseDTO> getCarts(String userId);

    public void clearCart(String userId);

    public CartResponseDTO updateCart(String userId, String bookId, Integer quantity);

    public CheckoutResponseData initiateCheckout(String userId, CartRequestDTO cartRequestDTO) throws Exception;

    public void processPostPayment(String userId, List<OrderDetail> checkoutOrderDetails);
}
