package com.assignment.BookStore.services;

import com.assignment.BookStore.dtos.requests.OrderRequestDTO;
import com.assignment.BookStore.dtos.responses.OrderResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrderById(String Id);

    List<OrderResponseDTO> GetOrdersByUserId(String userId);
    Page<OrderResponseDTO> getAllOrders(int page, int limit);

    OrderResponseDTO updateOrder(String Id, OrderRequestDTO orderRequestDTO);
    void deleteOrder(String Id);
    OrderResponseDTO updateOrderStatus(String Id, String status);
}
