package com.fundamentos.sprinboot.fundamentos.entitys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user",nullable=false,unique=true)
	private long id;
	@Column(name="name_user",length=50)
	private String name;
	@Column(name= "email_user",length=50,unique=true)
	private String email;
	
	private LocalDate birthDate;
	
	@OneToMany(mappedBy=("user"),cascade= CascadeType.ALL, fetch= FetchType.EAGER )
	@JsonManagedReference
	private List<Post> listPost= new ArrayList<>();
	

	public User() {
		
	}

	public User(String name, String email, LocalDate birthDate) {
		
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	

	public List<Post> getListPost() {
		return listPost;
	}

	public void setListPost(List<Post> listPost) {
		this.listPost = listPost;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", listPost="
				+ listPost + "]";
	}

	
}
