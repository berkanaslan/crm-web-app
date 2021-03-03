package com.berkanaslan.springdemo.dao;

import java.util.List;
import com.berkanaslan.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int id);
}
