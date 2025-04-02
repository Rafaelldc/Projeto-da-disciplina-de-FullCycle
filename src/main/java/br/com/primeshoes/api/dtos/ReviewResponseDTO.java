package br.com.primeshoes.api.dtos;

import java.sql.Date;

import br.com.primeshoes.api.enuns.Role;

public record ReviewResponseDTO(String name, String email, Role role, Date date) {

}
