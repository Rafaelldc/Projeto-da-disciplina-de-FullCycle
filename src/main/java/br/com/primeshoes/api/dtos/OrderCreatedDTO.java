package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.entites.User;
import br.com.primeshoes.api.enuns.OrderStatus;
import br.com.primeshoes.api.enuns.PaymentMethod;

public record OrderCreatedDTO(
		User user,
		float totalPrice,
		OrderStatus status,
		PaymentMethod paymentMethod,
		String trackingCode
		) {}