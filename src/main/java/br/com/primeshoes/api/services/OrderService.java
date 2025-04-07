package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.OrderCreatedDTO;
import br.com.primeshoes.api.dtos.OrderResponseDTO;
import br.com.primeshoes.api.dtos.OrderUpdateDTO;
import br.com.primeshoes.api.entites.Order;
import br.com.primeshoes.api.mappers.OrderMapper;
import br.com.primeshoes.api.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public OrderResponseDTO store(OrderCreatedDTO orderCreateDTO) {
		Order order = OrderMapper.toEntity(orderCreateDTO);
		Order orderResponse = orderRepository.save(order);
		return OrderMapper.toDTO(orderResponse);
	}
	
	public List<OrderResponseDTO> list() {
		return orderRepository.findAll().stream().map(OrderMapper::toDTO).toList();
	}
	
	public OrderResponseDTO show(long id) {
		Order order = orderRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Pedido com id " + id + " não foi encontrado")
						);
		return OrderMapper.toDTO(order);
	}
	
	public OrderResponseDTO update(OrderUpdateDTO orderUpdateDTO) {
		Order order = orderRepository
				.findById(orderUpdateDTO.id())
				.orElseThrow(()->new RuntimeException("Pedido não encontrado para alteração"));
		order.setTotalPrice(orderUpdateDTO.totalPrice());
		order.setStatus(orderUpdateDTO.status());
		order.setPaymentMethod(orderUpdateDTO.paymentMethod());
		
		return OrderMapper.toDTO(orderRepository.save(order));
	}
	
	public void destroy(long id) {
		Order order = orderRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
		orderRepository.delete(order);
	}
}