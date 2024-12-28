package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.entities.Cart;
import com.assignment.BookStore.entities.OrderDetail;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartResponseDTO {
    private String Id;
    private String userId;
    private List<OrderDetail> orderDetails;

    public static CartResponseDTO toDto(Cart cart) {
        CartResponseDTO cartResponseDTO = new CartResponseDTO();
        cartResponseDTO.setId(cart.getId());
        cartResponseDTO.setUserId(cart.getUserId());
        cartResponseDTO.setOrderDetails(cart.getOrderDetails());
        return cartResponseDTO;
    }
}
