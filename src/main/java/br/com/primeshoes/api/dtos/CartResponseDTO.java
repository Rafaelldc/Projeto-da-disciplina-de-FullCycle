package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.entites.User;

public record CartResponseDTO(
		long id,
		User user
		) {}