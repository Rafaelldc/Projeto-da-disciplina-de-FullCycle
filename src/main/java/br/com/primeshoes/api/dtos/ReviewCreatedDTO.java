package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.entites.ProductVariation;
import br.com.primeshoes.api.entites.User;

public record ReviewCreatedDTO(
		int rating,
		String comment,
		User user,
		ProductVariation productVariation
		) {}