package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.entites.Order;
import br.com.primeshoes.api.enuns.PaymentMethod;
import br.com.primeshoes.api.enuns.PaymentStatus;

public record PaymentUpdateDTO(
		long id,
		Order order,
		float amount,
		PaymentMethod paymentMethod,
		PaymentStatus paymentStatus
		) {}