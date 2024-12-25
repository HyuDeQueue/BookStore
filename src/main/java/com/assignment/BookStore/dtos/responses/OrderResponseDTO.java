package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.entities.Order;
import com.assignment.BookStore.entities.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private String id;

    private String userId;
    private Integer totalPrice;
    private String status;
    private String createdAt;
    private String updatedAt;

    private List<OrderDetail> orderDetails;

    public OrderResponseDTO toDto(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getUserId(),
                order.getTotalPrice(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getUpdatedAt(),
                order.getOrderDetails()
        );
    }
}
