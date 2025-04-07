package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.PromotionCreatedDTO;
import br.com.primeshoes.api.dtos.PromotionResponseDTO;
import br.com.primeshoes.api.entites.Promotion;

public class PromotionMapper {
	public static PromotionResponseDTO toDTO(Promotion promotion) {
		return new PromotionResponseDTO(promotion.getId(), promotion.getName(), promotion.getDiscountPercentage(), promotion.getStartDate(), promotion.getEndDate(), promotion.isActive(), promotion.getProductVariation());
	}
	
	public static Promotion toEntity(PromotionCreatedDTO promotionCreateDTO) {
		Promotion promotion = new Promotion();
		promotion.setName(promotionCreateDTO.name());
		promotion.setDiscountPercentage(promotionCreateDTO.discountPercentage());
		promotion.setStartDate(promotionCreateDTO.startDate());
		promotion.setEndDate(promotionCreateDTO.endDate());
		promotion.setActive(promotionCreateDTO.isActive());
		promotion.setProductVariation(promotionCreateDTO.productVariation());
		
		return promotion;
	}
}