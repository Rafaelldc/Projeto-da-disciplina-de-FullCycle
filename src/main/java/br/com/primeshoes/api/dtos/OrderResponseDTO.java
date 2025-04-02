package br.com.primeshoes.api.dtos;

import java.sql.Date;

import br.com.primeshoes.api.enuns.OrderStatus;

public record OrderResponseDTO(
    long id,
    float totalPrice,
    OrderStatus status,
    Date created_at,
    Date updated_at

) {

}
