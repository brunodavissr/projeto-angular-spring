package com.davismotors.estoquecarros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davismotors.estoquecarros.exception.CarroNaoEncontradoException;
import com.davismotors.estoquecarros.model.Carro;
import com.davismotors.estoquecarros.repository.CarroRepository;

@Service
@Transactional
public class CarroService {

	@Autowired
	private CarroRepository repository;
	
	public Carro listarCarro(Long id) {
		return repository.findById(id).orElseThrow(() -> new CarroNaoEncontradoException (
				"Carro de id " + id + " não encontrado"
		));
	}
	
	public List<Carro> listarCarros() {
		return repository.findAll();
	}
	
	public Carro adicionarCarro(Carro carro) {
		return repository.save(carro);
	}
	
	public Carro atualizarCarro(Carro carro) {
		return repository.save(carro);
	}
	
	public void deletarCarro(Long id) {
		repository.deleteById(id);
	}
	
}