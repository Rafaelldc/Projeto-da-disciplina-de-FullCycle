package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.ReviewCreatedDTO;
import br.com.primeshoes.api.dtos.ReviewResponseDTO;
import br.com.primeshoes.api.dtos.ReviewUpdateDTO;
import br.com.primeshoes.api.entites.Review;
import br.com.primeshoes.api.mappers.ReviewMapper;
import br.com.primeshoes.api.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	public ReviewResponseDTO store(ReviewCreatedDTO reviewCreateDTO) {
		Review review = ReviewMapper.toEntity(reviewCreateDTO);
		Review reviewResponse = reviewRepository.save(review);
		return ReviewMapper.toDTO(reviewResponse);
	}
	
	public List<ReviewResponseDTO> list() {
		return reviewRepository.findAll().stream().map(ReviewMapper::toDTO).toList();
	}
	
	public ReviewResponseDTO show(long id) {
		Review review = reviewRepository.findById(id).orElseThrow(()->new RuntimeException("Review com id" + id + "não encontrada"));
		return ReviewMapper.toDTO(review);
	}
	
	public ReviewResponseDTO update(ReviewUpdateDTO reviewUpdateDTO) {
		Review review = reviewRepository.findById(reviewUpdateDTO.id()).orElseThrow(()-> new RuntimeException("Review não encontrada para alteração"));
		review.setRating(reviewUpdateDTO.rating());
		review.setComment(reviewUpdateDTO.comment());
		review.setUser(reviewUpdateDTO.user());
		review.setProductVariation(reviewUpdateDTO.productVariation());
		
		return ReviewMapper.toDTO(reviewRepository.save(review));
	}
	
	public ReviewResponseDTO destroy(long id) {
		Review review = reviewRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Review Não encontrada para deleção"));
		return ReviewMapper.toDTO(review);
	}
}