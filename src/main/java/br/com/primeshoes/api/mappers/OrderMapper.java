package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.OrderCreatedDTO;
import br.com.primeshoes.api.dtos.OrderResponseDTO;
import br.com.primeshoes.api.entites.Order;

public class OrderMapper {

    public static Order toEntity(OrderCreatedDTO orderCreatedDTO){
        Order order = new Order();

        return order;
    }

    public static OrderResponseDTO toDTO(Order order){

        OrderResponseDTO orderResponse = new OrderResponseDTO(0, 0, null, null, null);

        return orderResponse;
    }
}
