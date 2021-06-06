package com.sample.app.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.sample.app.entity.BankAccount;
import com.sample.app.entity.Transaction;
//import com.codespeaks.rest.customerservice.exception.ResourceNotFoundException;
import com.sample.app.repo.BankAccountRepository;
import com.sample.app.repo.CustomerRepository;
import com.sample.app.repo.TransactionRepository;

import io.swagger.annotations.ApiOperation;


@RestController
public class BankAccountController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BankAccountRepository accountRepository;
	
	
	@ApiOperation(value = "LIST OF ALL BANK_ACCOUNTS")	
	
   
@GetMapping("/accounts")
public List<Object[]>accountNumber() 
{
  //  return (List<BankAccount>) repo.findaccountNumber();
	return (List<Object[]>) accountRepository.findaccountNumber();
	
}
	
	
	
@ApiOperation(value = "CREATE NEW BANK ACCOUNT")	
	@PostMapping(value = "/accounts/{customerId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public BankAccount save(@PathVariable Integer customerId,@RequestBody BankAccount  account) {
		return customerRepository.findById(customerId).map(customer -> {
			account.setCustomer(customer);
			return accountRepository.save(account);
			
		}).orElseThrow();

	 }
	
	

@ApiOperation(value = "ACCOUNT DETAILS")
	@GetMapping(value = "/accounts/{accountNumber}") 
	 public Page<BankAccount> all (@PathVariable String accountNumber,Pageable pageable)
	{ 
             return accountRepository.findByaccountNumber(accountNumber, pageable);
            
             
				}




}