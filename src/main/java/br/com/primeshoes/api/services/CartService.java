package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.CartCreatedDTO;
import br.com.primeshoes.api.dtos.CartResponseDTO;
import br.com.primeshoes.api.dtos.CartUpdateDTO;
import br.com.primeshoes.api.entites.Cart;
import br.com.primeshoes.api.mappers.CartMapper;
import br.com.primeshoes.api.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	public CartResponseDTO store(CartCreatedDTO cartCreateDTO) {
		Cart cart = CartMapper.toEntity(cartCreateDTO);
		Cart cartResponse = cartRepository.save(cart);
		return CartMapper.toDTO(cartResponse);
	}
	
	public List<CartResponseDTO> list() {
		return cartRepository.findAll().stream().map(CartMapper::toDTO).toList();
	}
	
	public CartResponseDTO update(CartUpdateDTO cartUpdateDTO) {
		Cart cart = cartRepository.findById(cartUpdateDTO.id()).orElseThrow(()->new RuntimeException("Carrinho não encontrado para alteração"));
		
		cart.setUser(cartUpdateDTO.user());
		
		cartRepository.save(cart);
		return CartMapper.toDTO(cart);
	}
	
	public CartResponseDTO show(long id) {
		Cart cart = cartRepository.findById(id).orElseThrow(
				()->new RuntimeException("Carrinho com id " + id + " não foi encontrado")
				);
		return CartMapper.toDTO(cart);
	}
	
	public void destroy(long id) {
		Cart cart = cartRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Carrinho não encontrado para deleção"));
		cartRepository.delete(cart);
	}
	
}