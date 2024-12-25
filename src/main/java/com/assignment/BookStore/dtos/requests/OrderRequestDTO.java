package com.assignment.BookStore.dtos.requests;

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
public class OrderRequestDTO {
    private String userId;
    private Integer totalPrice;
    private String status;
    private String createdAt;
    private String updatedAt;

    private List<OrderDetail> orderDetails;

    public Order toEntity() {
        Order order = new Order();
        order.setUserId(this.userId);
        order.setTotalPrice(this.totalPrice);
        order.setStatus(this.status);
        order.setCreatedAt(this.createdAt);
        order.setUpdatedAt(this.updatedAt);
        order.setOrderDetails(this.orderDetails);
        return order;
    }
}
