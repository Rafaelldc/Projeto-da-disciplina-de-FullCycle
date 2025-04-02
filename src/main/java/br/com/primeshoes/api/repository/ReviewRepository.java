package br.com.primeshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primeshoes.api.entites.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}