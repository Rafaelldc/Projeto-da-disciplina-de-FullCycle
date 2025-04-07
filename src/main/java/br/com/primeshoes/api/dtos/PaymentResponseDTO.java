package br.com.primeshoes.api.dtos;

import java.time.Instant;

import br.com.primeshoes.api.entites.Order;
import br.com.primeshoes.api.enuns.PaymentMethod;
import br.com.primeshoes.api.enuns.PaymentStatus;

public record PaymentResponseDTO(
		long id,
		Order order,
		float amount,
		PaymentMethod paymentMethod,
		PaymentStatus paymentStatus,
		Instant created_at,
		Instant updated_at
		) {}