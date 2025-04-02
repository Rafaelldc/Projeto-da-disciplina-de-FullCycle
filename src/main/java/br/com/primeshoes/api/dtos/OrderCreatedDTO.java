package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.entites.User;

public record OrderCreatedDTO(
    User user,
    float totalPrice
    

) {

}
