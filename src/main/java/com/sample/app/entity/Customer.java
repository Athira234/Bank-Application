package com.sample.app.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSetter;

@Table(name="CUSTOMER")
@Entity
public class Customer implements Serializable
{
	private static final long serialVersionUID = -6759774343110776659L;
	
	@Id
	@GeneratedValue
	@Column(name="CUSTOMERID",updatable = false)
	private Integer customerId;
	
	@Column(name="NAME")
	private String customerName;
	
	@Column(name="DATEOFBIRTH" ,nullable=true)
	private String dateofBirth;
	
	@Column(name="PHONENUMBER")
	private String phoneNumber;
	@Column(name="ADDRESS")
	private String address;
	@Lob
	@Column(name = "photo")
	private byte[] photo;

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth( String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer get() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
