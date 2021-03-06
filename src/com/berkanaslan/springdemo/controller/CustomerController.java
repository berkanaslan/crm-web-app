package com.berkanaslan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // Save the customer using our service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showformForUpdate(@RequestParam("customerId") int customerId, Model theModel) {

        // Get the customer from the service
        Customer theCustomer = customerService.getCustomer(customerId);

        // Set customers as a model attribute to pre-populute the form
        theModel.addAttribute("customer", theCustomer);

        // Send over to our form


        return "customer-form";
    }
    
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {
    	// Delete the customer
    	customerService.deleteCustomer(id);
    	return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";        
    }
}
