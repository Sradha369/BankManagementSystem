package com.springboot.bankapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long acntNo;
	@Column
	private String acntHolderName;
	@Column
	private Double acntBlnc;
	
	public Account() {
	}

	public Account(String acntHolderName, Double acntBlnc) {
		super();
		this.acntHolderName = acntHolderName;
		this.acntBlnc = acntBlnc;
	}

	public Long getAcntNo() {
		return acntNo;
	}

	public void setAcntNo(Long acntNo) {
		this.acntNo = acntNo;
	}

	public String getAcntHolderName() {
		return acntHolderName;
	}

	public void setAcntHolderName(String acntHolderName) {
		this.acntHolderName = acntHolderName;
	}

	public Double getAcntBlnc() {
		return acntBlnc;
	}

	public void setAcntBlnc(Double acntBlnc) {
		this.acntBlnc = acntBlnc;
	}

	@Override
	public String toString() {
		return "Account [acntNo=" + acntNo + ", acntHolderName=" + acntHolderName + ", acntBlnc=" + acntBlnc + "]";
	}
}
