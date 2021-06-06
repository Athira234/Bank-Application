package com.sample.app.repo;

import java.awt.print.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.app.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
	Page<BankAccount> findByCustomerCustomerId(Integer customerId, org.springframework.data.domain.Pageable pageable);
	@Query(value = "SELECT accountnumber FROM bank_account", nativeQuery = true)
    public List<Object[]> findaccountNumber();
	Page<BankAccount> findByaccountNumber(String accountNumber, org.springframework.data.domain.Pageable pageable);
	
}
