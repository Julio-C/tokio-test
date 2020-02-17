package com.example.api.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;
	

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}
	
	public ResponseEntity<?> list(Pageable peageble) {
		return ResponseEntity.ok(repository.findAll(peageble));
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public ResponseEntity<Customer> save(Customer create) {
		return ResponseEntity.ok(repository.save(create));
		
	}

	public ResponseEntity<?> deleteById(Long id){
		if(repository.findById(id).isPresent()){
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Customer> update(@Valid Customer create) {
		if(repository.findById(create.getId()).isPresent()){
			ResponseEntity.ok(repository.save(create));
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
