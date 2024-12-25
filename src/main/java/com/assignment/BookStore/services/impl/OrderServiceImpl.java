package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.OrderRequestDTO;
import com.assignment.BookStore.dtos.responses.OrderResponseDTO;
import com.assignment.BookStore.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class OrderServiceImpl implements OrderService {
    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        return null;
    }

    @Override
    public OrderResponseDTO getOrderById(String Id) {
        return null;
    }

    @Override
    public Page<OrderResponseDTO> getAllOrders(int page, int limit) {
        return null;
    }

    @Override
    public OrderResponseDTO updateOrder(String Id, OrderRequestDTO orderRequestDTO) {
        return null;
    }

    @Override
    public void deleteOrder(String Id) {

    }
}
