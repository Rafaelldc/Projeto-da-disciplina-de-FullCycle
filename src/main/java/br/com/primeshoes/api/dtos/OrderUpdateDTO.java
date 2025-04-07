package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.enuns.OrderStatus;
import br.com.primeshoes.api.enuns.PaymentMethod;

public record OrderUpdateDTO(
		long id,
		float totalPrice,
		OrderStatus status,
		PaymentMethod paymentMethod
		) {}