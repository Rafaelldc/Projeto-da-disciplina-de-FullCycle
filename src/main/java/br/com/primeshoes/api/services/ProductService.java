package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.repository.ProductRepository;

public class ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Save new product
	 * @param product
	 */
	public Product store(Product product)
	{
		return productRepository.save(product);
	}

    public List<Product> getAll() {
        return productRepository.findAll();
    }

}