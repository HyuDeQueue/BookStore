package com.assignment.BookStore.services;

import com.assignment.BookStore.dtos.requests.CartRequestDTO;
import com.assignment.BookStore.dtos.responses.CartResponseDTO;


public interface CartService {
    public CartResponseDTO addToCart(String userId, String bookId);

    public CartResponseDTO removeFromCart(String userId, String bookId);

    public CartResponseDTO getCart(String userId);

    public void clearCart(String userId);

    public CartResponseDTO updateCart(String userId, String bookId, Integer quantity);

    public void checkout(String userId, CartRequestDTO cartRequestDTO);
}