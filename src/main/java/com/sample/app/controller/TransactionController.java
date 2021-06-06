package com.sample.app.controller;

import java.io.IOException;


import java.util.Optional;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.entity.BankAccount;
import com.sample.app.entity.Transaction;
import com.sample.app.repo.BankAccountRepository;
import com.sample.app.repo.TransactionRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class TransactionController {
	@Autowired
	private BankAccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@ApiOperation(value = "TRANSACTION DETAILS")
 	@GetMapping(value = "/transactions/{accountNumber}") 
	public List<Transaction[]> AllTransactions(String accountNumber) 
	{
		
			return (List<Transaction[]>) transactionRepository.UsersTransaction(accountNumber);
		
	}
	
	

@PostMapping(value = "/transactions/deposite/{accountNumber}")
@ResponseStatus(code = HttpStatus.CREATED)
public Transaction Deposite(@PathVariable String accountNumber,
							@RequestParam String date,
							@RequestParam int depositamount,
							@RequestParam String description,@RequestParam String reference)	
{
	
	
		Transaction transaction=new Transaction();
		String AnyTrans= transactionRepository.findTransaction(accountNumber);
		if(AnyTrans!=null)
		{
			transaction.Balance=transactionRepository.findBalance(accountNumber);
		}
	     return accountRepository.findById(accountNumber).map(account-> {
		 
		 transaction.setAccount(account);
		 transaction.setDepositamount(depositamount);
		 transaction.setDescription(description);
		 transaction.setReference(reference);
		 transaction.Balance=transaction.Balance+depositamount;
		 transaction.setBalance(transaction.Balance);
   
    transaction.setDate(date);	
		return transactionRepository.save(transaction);
		
	}).orElseThrow();
	     
}




@PostMapping(value = "/transactions/withdraw/{accountNumber}")
@ResponseStatus(code = HttpStatus.CREATED)
public Transaction withdraw(@PathVariable String accountNumber,
							@RequestParam String date,
							@RequestParam int withdrawalamount,
							@RequestParam String description,@RequestParam String reference)	
{
	
		Transaction transaction=new Transaction();
		String AnyTrans= transactionRepository.findTransaction(accountNumber);
		
		if(AnyTrans!=null)
		{
		
			transaction.Balance=transactionRepository.findBalance(accountNumber);
		}
		
					
	     return accountRepository.findById(accountNumber).map(account-> {
		 
		 transaction.setAccount(account);
		 transaction.setWithdrawalamount(withdrawalamount);
		 transaction.setDescription(description);
		 transaction.setReference(reference);
		 transaction.Balance=transaction.Balance-withdrawalamount;
         transaction.setBalance(transaction.Balance);
         transaction.setDate(date);	
		return transactionRepository.save(transaction);
		
	}).orElseThrow();
}
	     

}
	
	










	
	 


	

	 
	
	
	

