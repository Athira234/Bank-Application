package com.sample.app.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Transaction implements Serializable {
	private static final long serialVersionUID = -6759774343110776659L;
	
	@Id
	@GeneratedValue
	@Column(name="TRANSACTION_ID",updatable = false)
	private Integer Transactionid;
	@Column(name="DATE")
	private String date;
	
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="WITHDRAWAL")
	private int withdrawalamount;

	@Column(name="DEPOSIT")
	private int depositamount;
	@Column(name="REFERENCE")
	private String reference;
	@Column(name="BALANCE",updatable=true)
	public int Balance;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "ACCOUNTNUMBER", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private BankAccount account;
	 
	 public int getBalance() {
			return Balance;
		}
		public void setBalance(int balance) {
			Balance = balance;
		}
	 
	 
	 
	 
	
	 public BankAccount getAccount() {
			return account;
		}
		public void setAccount(BankAccount account) {
			this.account = account;
		}
		
		public Integer getId() {
		return Transactionid;
	}
	public void setId(Integer Transactionid) {
		this.Transactionid = Transactionid;
	}
	public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
   	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getWithdrawalamount() {
		return withdrawalamount;
	}
	
	public void setWithdrawalamount(int withdrawlamount) {
		this.withdrawalamount = withdrawlamount;
	}
	public int getDepositamount() {
		return depositamount;
	}
	public void setDepositamount(int depositeamount) {
		this.depositamount = depositeamount;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
	
	
	
}