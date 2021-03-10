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

@Controller
public class CustomerController {

	@Autowired
    private CustomerRepository customerRepository;
	
	
	@RequestMapping("/index")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/signUp")
	public String signUp()
	{
		return "sign_up_page";
	}
	
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
		return "redirect:/reservation";
	}
	
	@RequestMapping(value="/signIn",method = RequestMethod.POST)  
	public String signIn(@RequestParam("email") String email,
            @RequestParam("password") String password, HttpServletRequest request)
	{
	    Customer customer = customerRepository.findByEmail(email);
	   
	    if (customer != null) {
	    	if (customer.getPassword().equals(password)) {
	    		request.getSession().setAttribute("customerId", customer.getCustId());
	    		request.getSession().setAttribute("customerEmail", customer.getEmail());
	    	
	    		return "redirect:/reservation";
	    	} else {
	    		handleSignInErrors("Incorrect Username/password");
	    	}
	    } else {
    		handleSignInErrors("Incorrect Username/password");
	    }
	    
		return "redirect:/";    
	}
	
	@RequestMapping(value="/profile",method = RequestMethod.GET)  
	public String viewProfile(HttpServletRequest request, Model model)
	{
		if (request.getSession().getAttribute("customerEmail") != null) {
			String customerEmail = (String) request.getSession().getAttribute("customerEmail");
		    Customer customer = customerRepository.findByEmail(customerEmail);
		    
		    if (customer != null) {
//		    	ModelAndView profile = new ModelAndView("profile_page");
//		    	profile.addObject("email", customer.getEmail());
//		    	profile.addObject("firstName", customer.getFirstName());
//		    	profile.addObject("lastName", customer.getLastName());
//		    	profile.addObject("phoneNumber", customer.getPhoneNumber());
//		    	profile.addObject("address", customer.getAddress());
//		    	profile.addObject("city", customer.getCity());
//		    	profile.addObject("postalCode", customer.getPostalCode());
//		    	profile.addObject("country", customer.getCountry());
		    	
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
	
	// for handling errors regarding 
	@ExceptionHandler(DataIntegrityViolationException.class)
	  public ModelAndView conflict(HttpServletRequest req, Exception ex) {
		System.out.println(ex);
		ModelAndView signUp = new ModelAndView("sign_up_page");
		signUp.addObject("error", "Email already exits.");
		return signUp;
	} 
	
	private ModelAndView handleSignInErrors(String error) {
		ModelAndView signIn = new ModelAndView("index");
		signIn.addObject("error", error);
		return signIn;
	}
}
