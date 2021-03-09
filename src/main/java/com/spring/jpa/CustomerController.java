package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

	@Autowired
    private CustomerRepository customerRepository;
	
	@RequestMapping("/index")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/reservation")
	public String reservation()
	{
		return "reservation_page";
	}
}
