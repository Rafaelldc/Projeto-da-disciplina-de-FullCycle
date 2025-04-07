package br.com.primeshoes.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.primeshoes.api.dtos.ReviewCreatedDTO;
import br.com.primeshoes.api.dtos.ReviewResponseDTO;
import br.com.primeshoes.api.dtos.ReviewUpdateDTO;
import br.com.primeshoes.api.services.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<ReviewResponseDTO> store(@RequestBody ReviewCreatedDTO reviewCreateDTO) {
		return new ResponseEntity<>(reviewService.store(reviewCreateDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewResponseDTO>> list() {
		return new ResponseEntity<>(reviewService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{id_review}")
	public ResponseEntity<ReviewResponseDTO> show(@PathVariable long id_review) {
		try {
			return new ResponseEntity<>(reviewService.show(id_review), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping
	public ResponseEntity<ReviewResponseDTO> update(@RequestBody ReviewUpdateDTO reviewUpdateDTO) {
		try {
			return new ResponseEntity<>(reviewService.update(reviewUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id_review}")
	public ResponseEntity<String> destroy(@PathVariable long id_review) {
		try {
			reviewService.destroy(id_review);
			return new ResponseEntity<>("Review deletada com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}