package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.PromotionCreatedDTO;
import br.com.primeshoes.api.dtos.PromotionResponseDTO;
import br.com.primeshoes.api.dtos.PromotionUpdateDTO;
import br.com.primeshoes.api.entites.Promotion;
import br.com.primeshoes.api.mappers.PromotionMapper;
import br.com.primeshoes.api.repository.PromotionRepository;

@Service
public class PromotionService {
	
	@Autowired
	PromotionRepository promotionRepository;
	
	public PromotionResponseDTO store(PromotionCreatedDTO promotionCreateDTO) {
		Promotion promotion = PromotionMapper.toEntity(promotionCreateDTO);
		Promotion promotionResponse = promotionRepository.save(promotion);
		return PromotionMapper.toDTO(promotionResponse);
	}
	
	public List<PromotionResponseDTO> list() {
		return promotionRepository.findAll().stream().map(PromotionMapper::toDTO).toList();
	}
	
	public PromotionResponseDTO show(long id) {
		Promotion promotion = promotionRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Promoção com id " + id + " não foi encontrada")
						);
		return PromotionMapper.toDTO(promotion);
	}
	
	public PromotionResponseDTO update(PromotionUpdateDTO promotionUpdateDTO) {
		Promotion promotion = promotionRepository
				.findById(promotionUpdateDTO.id())
				.orElseThrow(()->new RuntimeException("Promoção não encontrada para alteração"));
		promotion.setName(promotionUpdateDTO.name());
		promotion.setDiscountPercentage(promotionUpdateDTO.discountPercentage());
		promotion.setStartDate(promotionUpdateDTO.startDate());
		promotion.setEndDate(promotionUpdateDTO.endDate());
		promotion.setActive(promotionUpdateDTO.isActive());
		promotion.setProductVariation(promotionUpdateDTO.productVariation());
		
		return PromotionMapper.toDTO(promotionRepository.save(promotion));
	}
	
	public void destroy(long id) {
		Promotion promotion = promotionRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Promoção não encontrada"));
		promotionRepository.delete(promotion);
	}
}