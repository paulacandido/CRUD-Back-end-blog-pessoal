package com.generation.blogpessoal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	@Autowired
	private TemaRepository tema_repository;
	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAllTema(){
		return ResponseEntity.ok(tema_repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> GetByIdTema(@PathVariable long id){
		return tema_repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<TemaModel>> GetByDescricaoPostagem(@PathVariable String descricao){
		return ResponseEntity.ok(tema_repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<TemaModel> post (@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(tema_repository.save(tema));
	}
	@PutMapping
	public ResponseEntity<TemaModel> put (@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.OK).body(tema_repository.save(tema));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		tema_repository.deleteById(id);
	}
}
