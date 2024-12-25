package com.assignment.BookStore.controllers;

import com.assignment.BookStore.dtos.requests.OrderRequestDTO;
import com.assignment.BookStore.dtos.responses.OrderResponseDTO;
import com.assignment.BookStore.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    private ResponseEntity<OrderResponseDTO> addOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderRequestDTO));
    }

    @GetMapping
    private ResponseEntity<Page<OrderResponseDTO>> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(orderService.getAllOrders(page, limit));
    }

    @GetMapping("/{Id}")
    private ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable String Id) {
        return ResponseEntity.ok(orderService.getOrderById(Id));
    }

    @PutMapping("/{Id}")
    private ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable String Id,@RequestBody OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(orderService.updateOrder(Id, orderRequestDTO));
    }

    @DeleteMapping("/{Id}")
    private void deleteOrder(@PathVariable String Id) {
        orderService.deleteOrder(Id);
    }
}
