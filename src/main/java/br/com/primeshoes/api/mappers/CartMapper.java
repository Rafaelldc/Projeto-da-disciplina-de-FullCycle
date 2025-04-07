package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.CartCreatedDTO;
import br.com.primeshoes.api.dtos.CartResponseDTO;
import br.com.primeshoes.api.entites.Cart;

public class CartMapper {
	
	public static CartResponseDTO toDTO(Cart cart) {
		CartResponseDTO cartResponse = new CartResponseDTO(cart.getId(), cart.getUser());
		return cartResponse;
	}
	
	public static Cart toEntity(CartCreatedDTO cartCreateDTO) {
		Cart cart = new Cart();
		cart.setUser(cartCreateDTO.user());
		return cart;
	}
}