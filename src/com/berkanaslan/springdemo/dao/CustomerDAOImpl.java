package com.berkanaslan.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.berkanaslan.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// Execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// Return the results
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// Get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save the customer
		currentSession.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		// Get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Get customer
		return currentSession.get(Customer.class, customerId);
	}

}
