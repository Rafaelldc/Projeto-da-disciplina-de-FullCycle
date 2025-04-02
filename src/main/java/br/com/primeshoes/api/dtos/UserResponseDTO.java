package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.enuns.Role;
import java.sql.Date;
public record UserResponseDTO(
		long id,
		String name,
		String email, 
		Role role,
		Date created_at,
		Date updated_at
		) {}