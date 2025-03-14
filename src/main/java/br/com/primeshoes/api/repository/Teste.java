package br.com.primeshoes.api.repository;

import java.util.List;

import br.com.primeshoes.api.entites.Product;

public interface Teste {
	public void save(Product product);
	public List<String> list();
	public Product findById(Long id);
}
