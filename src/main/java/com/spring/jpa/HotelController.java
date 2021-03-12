package com.spring.jpa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HotelController {

	@Autowired
    private HotelRepository hotelRepository;
	
	@RequestMapping(value="/reservation",method = RequestMethod.GET)  
	public String signIn(HttpServletRequest request, Model model)
	{
		if (request.getSession().getAttribute("customerId") != null) {
			List<Hotel> rooms = hotelRepository.findAll();
			System.out.println(request.getSession().getAttribute("customerId"));
			model.addAttribute("rooms", rooms);
			return "reservation_page";	
		}  
		
		model.addAttribute("error", "Please Sign in to book reservations");
		return "redirect:/index";	
	}
}
