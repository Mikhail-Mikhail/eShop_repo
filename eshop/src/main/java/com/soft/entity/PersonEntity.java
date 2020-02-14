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
@Table(name = "person") 
public class PersonEntity extends BaseEntity {

	public PersonEntity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id    
    @Column(name = "id")    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private Long id;

    @Column(name = "name")
    private String name;
    
    //Static method to create instance. It is used for unit tests.
    public static BaseEntity createInstance() {      
      return new PersonEntity(1L, "IamPersonEntity"); 
    }

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

	//Stub method implementation to extend abstract "BaseEntity" class.
	@Override
	public byte[] getPhoto() {
		// TODO Auto-generated method stub
		return null;
	}
		
	 @Override
     public String toString() {
     	return this.getClass().getCanonicalName()+" : [id=" + id +"  name=" + name + "]";
     }
	
}
