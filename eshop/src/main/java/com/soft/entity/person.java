package com.soft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PERSON") 
public class person {

	public person(Long id, char surname) {
		super();
		this.id = id;
		this.surname = surname;
	}

	@Id    
    @Column(name = "id")    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private Long id;

    @Column(name = "surname")
    private char surname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getSurname() {
		return surname;
	}

	public void setSurname(char surname) {
		this.surname = surname;
	}        
}
