package com.spring.jpa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

	@Autowired
    private HotelRepository hotelRepository;
	
	@RequestMapping(value="/reservation",method = RequestMethod.GET)  
	public ModelAndView signIn(HttpServletRequest request)
	{
		List<Hotel> rooms = hotelRepository.findAll();
		System.out.println(request.getSession().getAttribute("customerId"));
		ModelAndView reservationPage = new ModelAndView("reservation_page");
		reservationPage.addObject("rooms", rooms);
		return reservationPage;
	    
	}
}
