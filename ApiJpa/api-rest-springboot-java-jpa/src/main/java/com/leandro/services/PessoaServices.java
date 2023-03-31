package com.leandro.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.exceptions.ResourceNotFoundException;
import com.leandro.model.Pessoa;
import com.leandro.repositories.PessoaRepository;

@Service
public class PessoaServices {
    private Logger logger = Logger.getLogger(PessoaServices.class.getName());

    @Autowired
    PessoaRepository repository;

    public List<Pessoa> findAll() {
	logger.info("Buscando todas as pessoas!");
	return repository.findAll();

    }

    public Pessoa findById(Long id) {
	logger.info("Buscando pessoa!");
	return repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado com este ID."));
    }

    public Pessoa create(Pessoa pessoa) {
	logger.info("Criando pessoa!");
	return repository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa) {
	logger.info("Alterando pessoa!");
	Pessoa entity = repository.findById(pessoa.getId())
		.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado com este ID."));
	entity.setNome(pessoa.getNome());
	entity.setEndereco(pessoa.getEndereco());
	entity.setGenero(pessoa.getGenero());
	return repository.save(pessoa);
    }

    public void delete(Long id) {
	logger.info("Excluíndo pessoa!");
	Pessoa entity = repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado com este ID."));
	repository.delete(entity);
    }
}
