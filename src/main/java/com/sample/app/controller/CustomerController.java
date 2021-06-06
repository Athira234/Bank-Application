package com.sample.app.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sample.app.entity.Customer;
//import com.sample.app.ResourceNotFoundException;
import com.sample.app.repo.CustomerRepository;
import io.swagger.annotations.ApiOperation;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	//private static final String DIR_TO_UPLOAD = "C:\\Users\\User\\Desktop\\ProjectImg\\";
	
	@ApiOperation(value = "Create new customer", notes = "Create new customer")
	@PostMapping(value = "/customers")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer save(@RequestParam String customerName,@RequestParam String phoneNumber,@RequestParam String dateofBirth,@RequestParam String address, @RequestParam MultipartFile file) throws IOException {
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setPhoneNumber(phoneNumber);
		customer.setDateofBirth(dateofBirth);
		customer.setAddress(address);
		customer.setPhoto(file.getBytes());
		return customerRepository.save(customer);
	 }
	

	@GetMapping(value = "/customers/{customerId}") 
	   public Customer findByCustomerId (@PathVariable Integer customerId){ 
	         return customerRepository.findById(customerId).orElseThrow();
	   }
	

	}

