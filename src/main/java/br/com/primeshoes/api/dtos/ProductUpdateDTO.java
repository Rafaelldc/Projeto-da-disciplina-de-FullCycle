package br.com.primeshoes.api.dtos;

public record ProductUpdateDTO(
		long id,
		String name,
		String description,
		float price,
		String category,
		String brand,
		String imageUrl,
		float rating
		) {}