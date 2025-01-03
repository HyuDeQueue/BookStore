package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.OrderRequestDTO;
import com.assignment.BookStore.dtos.responses.OrderResponseDTO;
import com.assignment.BookStore.entities.Order;
import com.assignment.BookStore.repositories.OrderRepository;
import com.assignment.BookStore.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = orderRequestDTO.toEntity();
        order.setStatus("Created");
        return OrderResponseDTO.toDto(orderRepository.save(order));
    }

    @Override
    public OrderResponseDTO getOrderById(String Id) {
        return orderRepository.findById(Id)
                .map(OrderResponseDTO::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    @Override
    public List<OrderResponseDTO> GetOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId)
                .stream().map(OrderResponseDTO::toDto)
                .toList();
    }

    @Override
    public Page<OrderResponseDTO> getAllOrders(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Order> orders = orderRepository.findAll(pageable);
        return orders.map(OrderResponseDTO::toDto);
    }



    @Override
    public OrderResponseDTO updateOrder(String Id, OrderRequestDTO orderRequestDTO) {
        Order order = orderRepository.findById(Id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        order.setUserId(orderRequestDTO.getUserId());
        order.setTotalPrice(orderRequestDTO.getTotalPrice());
        return OrderResponseDTO.toDto(orderRepository.save(order));
    }

    @Override
    public void deleteOrder(String Id) {
        if(!orderRepository.existsById(Id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
        orderRepository.deleteById(Id);
    }

    @Override
    public OrderResponseDTO updateOrderStatus(String Id, String status) {
        Order order = orderRepository.findById(Id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        order.setStatus(status);
        return OrderResponseDTO.toDto(orderRepository.save(order));
    }
}
