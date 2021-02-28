package com.berkanaslan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.berkanaslan.springdemo.dao.CustomerDAO;
import com.berkanaslan.springdemo.entity.Customer;
import com.berkanaslan.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Need to inject the Customer Service
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get customers from the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add the customers to the model
		theModel.addAttribute("customers", theCustomers);
			
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// Create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
}
