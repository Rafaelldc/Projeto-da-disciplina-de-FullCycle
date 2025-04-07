package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.OrderCreatedDTO;
import br.com.primeshoes.api.dtos.OrderResponseDTO;
import br.com.primeshoes.api.entites.Order;

public class OrderMapper {
	
	public static OrderResponseDTO toDTO(Order order) {
		OrderResponseDTO orderResponse = new OrderResponseDTO(order.getId(), order.getUser(), order.getTotalPrice(), order.getStatus(), order.getPaymentMethod(), order.getTrackingCode(), order.getCreated_at(), order.getUpdated_at());
		return orderResponse;
	}
	
	public static Order toEntity(OrderCreatedDTO orderCreatedDTO) {
		Order order = new Order();
		order.setUser(orderCreatedDTO.user());
		order.setTotalPrice(orderCreatedDTO.totalPrice());
		
		return order;
	}
}