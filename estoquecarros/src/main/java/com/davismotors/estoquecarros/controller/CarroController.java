package com.davismotors.estoquecarros.controller;

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

import com.davismotors.estoquecarros.model.Carro;
import com.davismotors.estoquecarros.service.CarroService;

@RestController
@RequestMapping("/carro")
@CrossOrigin(origins = "*")
public class CarroController {

	@Autowired
	private CarroService service;
	
	@GetMapping("/pesquisar/{id}")
	public ResponseEntity<Carro> listarCarro(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarCarro(id));
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Carro>> listarCarros() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarCarros());
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Carro> adicionarCarro(@RequestBody Carro carro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarCarro(carro));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Carro> atualizarCarro(@RequestBody Carro carro) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizarCarro(carro));
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletarCarro(@PathVariable Long id) {
		service.deletarCarro(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
