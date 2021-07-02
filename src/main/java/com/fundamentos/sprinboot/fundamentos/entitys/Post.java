package com.fundamentos.sprinboot.fundamentos.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_post",nullable = false, unique=true)
	private long id;
	@Column(name="country", length = 50)
	private String country;
	@Column(name="country_city", length= 50 )
	private String countryCity;
	
	@ManyToOne
	private User user;
	
	public Post() {
		
	}


	public Post(long id, String country, String countryCity) {
		
		this.id = id;
		this.country = country;
		this.countryCity = countryCity;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCountryCity() {
		return countryCity;
	}


	public void setCountryCity(String countryCity) {
		this.countryCity = countryCity;
	}
	
}
