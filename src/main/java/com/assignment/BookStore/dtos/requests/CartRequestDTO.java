package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.Cart;
import com.assignment.BookStore.entities.OrderDetail;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartRequestDTO {
    private String userId;
    private List<OrderDetail> orderDetails;

    public Cart toEntity(Cart cart) {
        Cart cartRequestDTO = new Cart();
        cartRequestDTO.setUserId(cart.getUserId());
        cartRequestDTO.setOrderDetails(cart.getOrderDetails());
        return cartRequestDTO;
    }
}
