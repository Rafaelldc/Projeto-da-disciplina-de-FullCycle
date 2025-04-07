package br.com.primeshoes.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.primeshoes.api.dtos.CartCreatedDTO;
import br.com.primeshoes.api.dtos.CartResponseDTO;
import br.com.primeshoes.api.dtos.CartUpdateDTO;
import br.com.primeshoes.api.services.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping
	public ResponseEntity<CartResponseDTO> store(@RequestBody CartCreatedDTO cartCreateDTO) {
		return new ResponseEntity<>(cartService.store(cartCreateDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CartResponseDTO>> list() {
		return new ResponseEntity<>(cartService.list(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id_cart}")
	public ResponseEntity<CartResponseDTO> show(@PathVariable long id_cart) {
		try {
			return new ResponseEntity<>(cartService.show(id_cart), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping
	public ResponseEntity<CartResponseDTO> update(@RequestBody CartUpdateDTO cartUpdateDTO) {
		try {
			return new ResponseEntity<>(cartService.update(cartUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id_cart}")
	public ResponseEntity<String> destroy(@PathVariable long id_cart) {
		try {
			cartService.destroy(id_cart);
			return new ResponseEntity<>("Carrinho deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}