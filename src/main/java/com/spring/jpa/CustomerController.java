package com.spring.jpa;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*
 * Submitted By: Anmoldeep Singh Gill, Mohammad Bakir
 * Student Number: 301044883, 300987420
 * Submission date: 12th March 2021
 * */

@Controller
public class CustomerController {

	@Autowired
    private CustomerRepository customerRepository;
	
	// renders the index view
	@RequestMapping("/index")
	public String home(Model model)
	{
		model.addAttribute("error", null);
		return "index";
	}
	
	// renders the sign up view
	@RequestMapping("/signUp")
	public String signUp(Model model)
	{
		model.addAttribute("error", null);
		return "sign_up_page";
	}
	
	// gets the data from sign up view and saves the customer
	@RequestMapping(value="/signUp",method = RequestMethod.POST)  
	public String register(@RequestParam("email") String email,
            @RequestParam("password") String password,
			@RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("postalCode") String postalCode,
            @RequestParam("country") String country)
	{
		Customer customer = new Customer(email, password, firstName, lastName, phoneNumber,
				address, city, state, postalCode, country);
	    customerRepository.save(customer);
	    
//		ModelAndView index = new ModelAndView("index");
		return "redirect:/";
	}
	
	// method to handle sign in
	@RequestMapping(value="/signIn",method = RequestMethod.POST)  
	public String signIn(@RequestParam("email") String email,
            @RequestParam("password") String password, HttpServletRequest request, Model model)
	{
	    Customer customer = customerRepository.findByEmail(email);
	   
	    // checking if the customer exists
	    if (customer != null) {
	    	// checking if the password matches from the database
	    	if (customer.getPassword().equals(password)) {
	    		
	    		// saving customer Id and email in the session
	    		request.getSession().setAttribute("customerId", customer.getCustId());
	    		request.getSession().setAttribute("customerEmail", customer.getEmail());
	    	
	    		return "redirect:/searchRooms";
	    	} else {
	    		model.addAttribute("error", "Incorrect Username/password");
	    		return "index";
	    	}
	    } else {
    		model.addAttribute("error", "Account does not exists.");
    		return "index";
	    }
	        
	}
	
	// handles view profile for customer gets the data of a customer by id from session
	@RequestMapping(value="/profile",method = RequestMethod.GET)  
	public String viewProfile(HttpServletRequest request, Model model)
	{
		if (request.getSession().getAttribute("customerEmail") != null) {
			String customerEmail = (String) request.getSession().getAttribute("customerEmail");
		    Customer customer = customerRepository.findByEmail(customerEmail);
		    
		    if (customer != null) {
		    	
		    	model.addAttribute("email", customer.getEmail());
		    	model.addAttribute("firstName", customer.getFirstName());
		    	model.addAttribute("lastName", customer.getLastName());
		    	model.addAttribute("phoneNumber", customer.getPhoneNumber());
		    	model.addAttribute("address", customer.getAddress());
		    	model.addAttribute("city", customer.getCity());
		    	model.addAttribute("state", customer.getState());
		    	model.addAttribute("postalCode", customer.getPostalCode());
		    	model.addAttribute("country", customer.getCountry());
		    	return "profile_page";
		    } 
		    else 
		    {
		    	return "redirect:/";  
		    }
		}
		return "redirect:/";   
	}
	
	// handles the post route for saving customer details
	@RequestMapping(value="/profile",method = RequestMethod.POST)  
	public String updateProfile(HttpServletRequest request,
			@RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("postalCode") String postalCode,
            @RequestParam("country") String country)
	{
		if (request.getSession().getAttribute("customerEmail") != null) {
			String customerEmail = (String) request.getSession().getAttribute("customerEmail");
		    Customer customer = customerRepository.findByEmail(customerEmail);
		    
		    if (customer != null) {
		    	
		    	Customer updatedCustomer = new Customer(customer.getCustId(),customer.getEmail(), customer.getPassword(), firstName, lastName, phoneNumber,
						address, city, state, postalCode, country);
		    	customerRepository.save(updatedCustomer);
		    	return "redirect:/profile";
		    } 
		    else 
		    {
		    	return "redirect:/";  
		    }
		}
		return "redirect:/";   
	}
	
	// for handling errors regarding database update or save in customer controller
	@ExceptionHandler(DataIntegrityViolationException.class)
	  public ModelAndView conflict(HttpServletRequest req, Exception ex) {
		System.out.println(ex);
		ModelAndView signUp = new ModelAndView("sign_up_page");
		signUp.addObject("error", "Email already exits.");
		return signUp;
	} 
	
	// mapping for logout GET route to clear the session and redirect to index
	@RequestMapping(value="/logout",method = RequestMethod.GET)  
	public String logout(HttpServletRequest request)
	{
		request.getSession().setAttribute("customerId", null);
		request.getSession().setAttribute("customerEmail", null);
		return "redirect:/index";
	}
	
}
