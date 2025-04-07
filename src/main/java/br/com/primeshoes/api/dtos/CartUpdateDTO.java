package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.entites.User;

public record CartUpdateDTO(
		long id,
		User user
		) {
}