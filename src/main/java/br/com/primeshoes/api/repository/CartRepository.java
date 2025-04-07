package br.com.primeshoes.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.primeshoes.api.entites.Cart;
import br.com.primeshoes.api.entites.CartItem;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	
	@NativeQuery("SELECT cart_items.* FROM cart_items JOIN carts ON carts.id = cart_items.cart_id WHERE carts.id = :id")
	public List<CartItem> listCartItems(long id);
}