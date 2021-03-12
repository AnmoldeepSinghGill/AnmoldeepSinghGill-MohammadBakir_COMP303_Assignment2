package com.spring.jpa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {

	@Autowired
    private HotelRepository hotelRepository;
	
	@RequestMapping(value="/searchRooms",method = RequestMethod.GET)  
	public String renderSearchRooms(HttpServletRequest request, Model model)
	{
		if (request.getSession().getAttribute("customerId") != null) {
			return "search_rooms_page";	
		}  
		
		model.addAttribute("error", "Please Sign in to search rooms");
		return "redirect:/index";	
	}
	
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
