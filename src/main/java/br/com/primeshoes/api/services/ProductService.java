package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.ProductDTO;
import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.mappers.ProductMapper;
import br.com.primeshoes.api.repository.ProductRepository;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Save new product
	 * @param product
	 */
	public Product store(ProductDTO productDTO)
	{
		Product product = ProductMapper.toEntity(productDTO);
		return productRepository.save(product);
	}
	
	public List<ProductDTO> getAll()
	{
		return productRepository.findAll().stream().map(ProductMapper::toDTO).toList();
	}

}