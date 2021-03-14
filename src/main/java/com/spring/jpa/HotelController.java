package com.spring.jpa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Submitted By: Anmoldeep Singh Gill, Mohammad Bakir
 * Student Number: 301044883, 300987420
 * Submission date: 12th March 2021
 * */

// hotel controler
@Controller
public class HotelController {

	// hotel repository to get data from database
	@Autowired
    private HotelRepository hotelRepository;
	
	// renders the search rooms views if a user is signed in
	@RequestMapping(value="/searchRooms",method = RequestMethod.GET)  
	public String renderSearchRooms(HttpServletRequest request, Model model)
	{
		if (request.getSession().getAttribute("customerId") != null) {
			return "search_rooms_page";	
		}  
		
		model.addAttribute("error", "Please Sign in to search rooms");
		return "redirect:/index";	
	}
	
	// saves the arrival date and departure date in the session to be used in the future
	@RequestMapping(value="/searchRooms",method = RequestMethod.POST)  
	public String searchRooms(HttpServletRequest request, Model model, 
			@RequestParam("arrivalDate") String arrivalDate,
			@RequestParam("departureDate") String departureDate)
	{
		if (request.getSession().getAttribute("customerId") != null) {
			System.out.println(request.getSession().getAttribute("customerId"));
			
			request.getSession().setAttribute("arrivalDate", arrivalDate);
			request.getSession().setAttribute("departureDate", departureDate);
			
			return "redirect:/reservation";	
		}  
		
		model.addAttribute("error", "Please Sign in to search rooms");
		return "redirect:/index";	
	}
	
	// rendring the reservation view by populating the view with all the rooms in the system if the user is
	// signed in
	@RequestMapping(value="/reservation",method = RequestMethod.GET)  
	public String signIn(HttpServletRequest request, Model model)
	{
		if (request.getSession().getAttribute("customerId") != null) {
			if (request.getSession().getAttribute("arrivalDate") != null &&
					request.getSession().getAttribute("departureDate") != null) {
				List<Hotel> rooms = hotelRepository.findAll();
				System.out.println(request.getSession().getAttribute("customerId"));
				model.addAttribute("rooms", rooms);
				return "reservation_page";	
			} else {
				return "redirect:/searchRooms";
			}
		}  
		
		model.addAttribute("error", "Please Sign in to book reservations");
		return "redirect:/index";	
	}
}
