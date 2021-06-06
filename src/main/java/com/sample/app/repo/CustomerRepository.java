package com.sample.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "SELECT * FROM customer where accountnumber=?1 ",
			nativeQuery = true)


			public Customer  ImageDetail(Integer CostumerId);
}