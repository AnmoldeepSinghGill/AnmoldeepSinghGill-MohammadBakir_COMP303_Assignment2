package com.spring.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private HotelRepository hotelRepository;

	@RequestMapping(value = "/bookReservation", method = RequestMethod.POST)
	public String saveReservation(HttpServletRequest request, Model model, @RequestParam("id") int roomId,
			@RequestParam("price") double price, @RequestParam("numberOfNights") int numberOfNights,
			@RequestParam("numberOfGuests") int numberOfGuests) {
		if (request.getSession().getAttribute("customerId") != null) {
			int customerId = (int) request.getSession().getAttribute("customerId");

			Reservation reservation = new Reservation(customerId, roomId, numberOfNights, numberOfGuests);

			// calculating total amount
			double totalAmount = reservation.calculateTotalAmount(price);
			reservation.setTotalAmount(totalAmount);
			System.out.println(totalAmount);

			reservationRepository.save(reservation);

			model.addAttribute("totalAmount", totalAmount);
			return "payment_page";
		}

		model.addAttribute("error", "Please Sign in to book reservations");
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/processPayment", method = RequestMethod.POST)
	public String showPaymentSuccesfull() {
		return "payment_successful";
	}
	
	@RequestMapping(value = "/showReservations", method = RequestMethod.GET)
	public String showAllCustomerReservations(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("customerId") != null) {
			int customerId = (int) request.getSession().getAttribute("customerId");
			List<Reservation> reservations = reservationRepository.findByCustomerId(customerId);
//			List<Hotel> rooms = hotelRepository.findAll();
//			Hotel[] roomBookedForReservation = new Hotel[reservations.size()];
			for (Reservation reservation : reservations) {
				int roomId = reservation.getRoomId();
				Optional<Hotel> optionalRoom = hotelRepository.findById(roomId);
				if (optionalRoom.isPresent()) {
					Hotel room = optionalRoom.get();
					reservation.setRoom(room);
				}
			}
			
			System.out.println(request.getSession().getAttribute("customerId"));
			model.addAttribute("reservations", reservations);
			return "reservation_list";	
		}  
		
		model.addAttribute("error", "Please Sign in to book reservations");
		return "redirect:/index";	
	}
	
	@RequestMapping(value = "/deleteReservation", method = RequestMethod.POST)
	public String deleteReservation(@RequestParam("id") int id) {
		System.out.println(id);
		reservationRepository.deleteById(id);
		return "redirect:/showReservations";
	}

	// for handling errors regarding database update or save in reservation controller
	@ExceptionHandler(DataIntegrityViolationException.class)
	public String errorHandler(HttpServletRequest req, Exception ex) {
		System.out.println(ex);
//		ModelAndView signUp = new ModelAndView("sign_up_page");
//		re.addObject("error", "Email already exits.");
		return "redirect:/reservation_page";
	}
}
