package com.sample.app.repo;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import com.sample.app.entity.BankAccount;
import com.sample.app.entity.Transaction;


public interface TransactionRepository  extends JpaRepository<Transaction, Integer> 
{
	
Page<Transaction>  findByAccount(String accountNumber, org.springframework.data.domain.Pageable pageable);
@Query(value = "SELECT * FROM transaction where accountnumber=?1 limit 1",
nativeQuery = true)


public String  findTransaction(String accountNumber);

@Query(value = "SELECT balance  FROM transaction where accountnumber=?1 order by transaction_id desc limit 1 ",
			 nativeQuery = true)

public Integer  findBalance(String accountNumber);


@Query(value = "SELECT * FROM transaction where accountnumber=?1 ",
			nativeQuery = true)
public List<Transaction[]>  UsersTransaction(String accountNumber);
			
}