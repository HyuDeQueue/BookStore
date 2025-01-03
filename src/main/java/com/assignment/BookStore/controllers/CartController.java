package com.assignment.BookStore.controllers;

import com.assignment.BookStore.dtos.requests.CartRequestDTO;
import com.assignment.BookStore.dtos.responses.CartResponseDTO;
import com.assignment.BookStore.dtos.responses.OrderResponseDTO;
import com.assignment.BookStore.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("create/{userId}")
    private ResponseEntity<CartResponseDTO> createCart(@PathVariable String userId, @RequestParam String bookId){
        return ResponseEntity.ok(cartService.addToCart(userId, bookId));
    }

    @PutMapping("/remove/{userId}/{bookId}")
    private ResponseEntity<CartResponseDTO> removeCart(@PathVariable String userId, @PathVariable String bookId) {
        return ResponseEntity.ok(cartService.removeFromCart(userId, bookId));
    }

    @GetMapping("/{userId}")
    private ResponseEntity<CartResponseDTO> getCart(@PathVariable String userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @PutMapping("/update/{userId}/{bookId}")
    private ResponseEntity<CartResponseDTO> updateCart(@PathVariable String userId, @PathVariable String bookId, @RequestParam Integer quantity) {
        return ResponseEntity.ok(cartService.updateCart(userId, bookId, quantity));
    }

    @DeleteMapping("/{userId}")
    private void clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
    }

    @PostMapping("/checkout/{userId}")
    private ResponseEntity<OrderResponseDTO> checkout(@PathVariable String userId, @RequestBody CartRequestDTO cartRequestDTO) throws Exception {
        return ResponseEntity.ok(cartService.initiateCheckout(userId, cartRequestDTO));
    }
}

