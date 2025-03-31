package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.ProductDTO;
import br.com.primeshoes.api.entites.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getName());
    }
    public static Product toEntity(ProductDTO productDTO){
        
        Product product = new Product();
        product.setName(productDTO.name());
       
        return product;
    }
}

