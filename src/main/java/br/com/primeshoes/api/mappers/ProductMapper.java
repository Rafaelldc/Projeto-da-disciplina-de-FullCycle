package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.ProductDTO;
import br.com.primeshoes.api.entites.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getName(),product.getPrice(), product.getStock());
    }
    public static Product toEntity(ProductDTO productDto){
        
        Product product = new Product();
        product.setName(productDto.name());
        product.setPrice(productDto.price());
        product.setStock(productDto.stock());
        return product;
    }
}

