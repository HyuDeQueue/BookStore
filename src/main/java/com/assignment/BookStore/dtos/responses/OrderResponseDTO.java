package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.entities.Order;
import com.assignment.BookStore.entities.OrderDetail;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponseDTO {
    private String id;

    private String userId;
    private Integer totalPrice;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<OrderDetail> orderDetails;

    public static OrderResponseDTO toDto(Order order) {
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
