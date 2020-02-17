package com.example.api.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping("/")
	@ApiOperation(value = "Retorna a Lista de cadastros.")
	public ResponseEntity<?> findPaging(Pageable peageble) {
		return ResponseEntity.ok(service.list(peageble));
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna a Lista de cadastros com o nome em ordem Asc.")
	public List<Customer> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna os dados de um cliente pelo ID.")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	@PostMapping 
	@Transactional
	@ApiOperation(value = "Cadastra um cliente.")
	public ResponseEntity<Customer> create(@RequestBody @Valid  Customer create) {
		return service.save(create);
	}
	
	@PutMapping
	@Transactional
	@ApiOperation(value = "Atualiza um cadastro existente.")
	public ResponseEntity<Customer> update(@RequestBody @Valid  Customer create) {
		return service.update(create);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@ApiOperation(value = "Deleta um Cadastro pelo ID.")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
	

}
