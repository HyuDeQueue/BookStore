package com.assignment.BookStore.dtos.requests;

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
public class OrderRequestDTO {
    private String userId;
    private Integer totalPrice;

    private List<OrderDetail> orderDetails;

    public Order toEntity() {
        Order order = new Order();
        order.setUserId(this.userId);
        order.setTotalPrice(this.totalPrice);
        order.setOrderDetails(this.orderDetails);
        return order;
    }
}
