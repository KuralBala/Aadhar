package com.qspider.springbootproject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", gender=" + gender + ", adhar=" + adhar + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String uname;
	private String gender;
	@OneToOne(cascade = CascadeType.ALL)
	private Aadhar adhar;
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Aadhar getAdhar() {
		return adhar;
	}

	public void setAdhar(Aadhar adhar) {
		this.adhar = adhar;
	}

	

}
