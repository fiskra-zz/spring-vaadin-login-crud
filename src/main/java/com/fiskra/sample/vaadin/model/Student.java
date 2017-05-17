package com.fiskra.sample.vaadin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;
	
	private String phone;
	
	private String eMail;
	
	private Date birthDate;
	
	public Student(){}
	
	public Student(String firstName,String lastName, String phone, String eMail,Date birthday){
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthday;
		this.eMail = eMail;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Student[id=%d, firstName='%s',lastName='%s',eMail='%s',birthday='%s']", id ,firstName, lastName, phone, eMail,birthDate);
	}

}
