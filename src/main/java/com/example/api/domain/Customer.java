	package com.example.api.domain;
	
	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
	
	@Entity
	public class Customer {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
	
		@Column(nullable = false)
		@NotEmpty
		@NotNull
		private String name;
	 
		@Column(nullable = false)
		@NotEmpty
		@Email
		@NotNull
		private String email;
	
//		@OneToMany(mappedBy = "customer")
//		private List<Address> endereco;
		
		
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public String getEmail() {
			return email;
		}
	
		public void setEmail(String email) {
			this.email = email;
		}
	
//		public List<Address> getEndereco() {
//			return endereco;
//		}
//	
//		public void setEndereco(List<Address> endereco) {
//			this.endereco = endereco;
//		}
	
	}
