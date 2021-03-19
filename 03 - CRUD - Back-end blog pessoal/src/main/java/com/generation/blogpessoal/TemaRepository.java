package com.generation.blogpessoal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<TemaModel,Long> {
	
		  public List<TemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
		
}
