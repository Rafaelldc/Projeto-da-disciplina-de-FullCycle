package br.com.primeshoes.api.dtos;

public record CartitemCreatedDTO(
    Integer quantity,
    float subtotal
) {
}
