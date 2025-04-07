package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.PaymentCreatedDTO;
import br.com.primeshoes.api.dtos.PaymentResponseDTO;
import br.com.primeshoes.api.entites.Payment;

public class PaymentMapper {
	public static PaymentResponseDTO toDTO (Payment payment) {
		return new PaymentResponseDTO(payment.getId(), payment.getOrder(), payment.getAmount(), payment.getPaymentMethod(), payment.getPaymentStatus(), payment.getCreated_at(), payment.getUpdated_at());
	}
	
	public static Payment toEntity(PaymentCreatedDTO paymentCreateDTO) {
		Payment payment = new Payment();
		payment.setOrder(paymentCreateDTO.order());
		payment.setAmount(paymentCreateDTO.amount());
		payment.setPaymentMethod(paymentCreateDTO.paymentMethod());
		payment.setPaymentStatus(paymentCreateDTO.paymentStatus());
		
		return payment;
	}
}