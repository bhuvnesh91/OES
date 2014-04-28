/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebo.oes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author akathpal
 */
@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ID")
	@Id
	private int id;
	@Column(name = "NAME")
	private String firstName;
	@Column(name = "PHONE_NUMBER")
	private int phoneNumber;
	@Column(name = "EMAIL_ID")
	private String emailId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}