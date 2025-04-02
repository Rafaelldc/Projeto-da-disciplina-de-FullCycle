package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.CartCreatedDTO;
import br.com.primeshoes.api.dtos.CartResponseDTO;
import br.com.primeshoes.api.entites.Cart;

public class CartMapper {

    public static Cart toEntity(CartCreatedDTO cartCreatedDTO){
        Cart cart = new Cart();
        return cart;
    }

    public static CartResponseDTO toDTO(Cart Cart){
        
        CartResponseDTO cartResponse = new CartResponseDTO(0);

        return cartResponse;
    }
}
