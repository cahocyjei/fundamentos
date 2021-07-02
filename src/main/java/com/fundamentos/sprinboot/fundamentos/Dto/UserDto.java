package com.fundamentos.sprinboot.fundamentos.Dto;

import java.time.LocalDate;

public class UserDto {
	
	private long id;
	private String name;
	private String email;
	private LocalDate birthDate;
	
	public UserDto() {
	
	}

	public UserDto(long id, String name, String email, LocalDate birthDate) {
		
		this.id = id;
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

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	

}
