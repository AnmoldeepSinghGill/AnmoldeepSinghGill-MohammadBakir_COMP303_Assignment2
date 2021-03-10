package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public @ResponseBody ModelAndView register(@RequestParam("email") String email,
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
		ModelAndView index = new ModelAndView("index");
		return index;
	}
}
