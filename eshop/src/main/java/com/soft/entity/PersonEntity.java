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
public class PersonEntity {

	public PersonEntity(Long id, char name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id    
    @Column(name = "ID")    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private Long id;

    @Column(name = "NAME")
    private char name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}        
}
