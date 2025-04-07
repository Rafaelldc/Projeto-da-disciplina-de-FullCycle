package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.ProductCreatedDTO;
import br.com.primeshoes.api.dtos.ProductResponseDTO;
import br.com.primeshoes.api.entites.Product;

public class ProductMapper {
	public static ProductResponseDTO toDTO(Product product) {
		return new ProductResponseDTO(product.getId(), product.getName(),product.getDescription(), product.getPrice(), product.getCategory(), product.getBrand(), product.getImageUrl(),product.getRating(), product.getCreated_at(), product.getUpdated_at());
	}
	public static Product toEntity(ProductCreatedDTO productCreateDTO) {
		Product product = new Product();
		product.setName(productCreateDTO.name());
		product.setDescription(productCreateDTO.description());
		product.setPrice(productCreateDTO.price());
		product.setCategory(productCreateDTO.category());
		product.setBrand(productCreateDTO.brand());
		product.setImageUrl(productCreateDTO.imageUrl());
		product.setRating(productCreateDTO.rating());
		return product;
	}
}