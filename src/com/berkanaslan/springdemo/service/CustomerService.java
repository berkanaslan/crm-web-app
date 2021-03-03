package com.berkanaslan.springdemo.service;

import java.util.List;

import com.berkanaslan.springdemo.entity.Customer;

public interface CustomerService {
	List<Customer> getCustomers();
	void saveCustomer(Customer theCustomer);
	Customer getCustomer(int customerId);
	void deleteCustomer(int id);
}
 