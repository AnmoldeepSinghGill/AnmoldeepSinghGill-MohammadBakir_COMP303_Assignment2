package com.spring.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

/*
 * Submitted By: Anmoldeep Singh Gill, Mohammad Bakir
 * Student Number: 301044883, 300987420
 * Submission date: 12th March 2021
 * */

// reservation controller
@Controller
public class ReservationController {

	// autowiring reservation repository to get data
	@Autowired
	private ReservationRepository reservationRepository;
	
	// autowiring hotel repository to get data
	@Autowired
	private HotelRepository hotelRepository;

	// book reservation request mapping to save a new reservation
	@RequestMapping(value = "/bookReservation", method = RequestMethod.POST)
	public String saveReservation(HttpServletRequest request, Model model, @RequestParam("id") int roomId,
			@RequestParam("price") double price, @RequestParam("numberOfNights") int numberOfNights,
			@RequestParam("numberOfGuests") int numberOfGuests) {
		
		// checking if the customer Id is stored in the session (customer is signed in)
		if (request.getSession().getAttribute("customerId") != null) {
			
			// find the customer if signed in
			int customerId = (int) request.getSession().getAttribute("customerId");
			
			// getting arrival and departure date from the session
			String arrivalDate = (String) request.getSession().getAttribute("arrivalDate");
			String departureDate = (String) request.getSession().getAttribute("departureDate");
			
			// getting arrival and departure date from the session
			Reservation reservation = new Reservation(customerId, roomId, numberOfNights, numberOfGuests, 
					arrivalDate, departureDate);

			// calculating total amount from the reservation class
			double totalAmount = reservation.calculateTotalAmount(price);
			reservation.setTotalAmount(totalAmount);
			System.out.println(totalAmount);

			// saving the reservation object using reservation repository
			reservationRepository.save(reservation);
			
			// sending the total calculated total amount to the payment page to show there
			model.addAttribute("totalAmount", totalAmount);
			
			// rendring the payment page
			return "payment_page";
		}

		// if the user not logged in give this error
		model.addAttribute("error", "Please Sign in to book reservations");
		return "redirect:/index";
	}
	
	// redirects the user to payment successful page after customer enters their payment details
	@RequestMapping(value = "/processPayment", method = RequestMethod.POST)
	public String showPaymentSuccesfull() {
		return "payment_successful";
	}
	
	// finds all the reservations for the currently signed in customer
	@RequestMapping(value = "/showReservations", method = RequestMethod.GET)
	public String showAllCustomerReservations(HttpServletRequest request, Model model) {
		
		// checking if a customer is signed in
		if (request.getSession().getAttribute("customerId") != null) {
			// getting the customer id from session
			int customerId = (int) request.getSession().getAttribute("customerId");
			
			// getting all the reservations for that specific customer by ID
			List<Reservation> reservations = reservationRepository.findByCustomerId(customerId);
			
			// finding the room by Id from each reservation object and assigning it tot
			// the transient object called room to shoethe rrom details on the jsp page
			for (Reservation reservation : reservations) {
				int roomId = reservation.getRoomId();
				Optional<Hotel> optionalRoom = hotelRepository.findById(roomId);
				if (optionalRoom.isPresent()) {
					Hotel room = optionalRoom.get();
					reservation.setRoom(room);
				}
			}
			
			// getting the list of all the rooms
			List<Hotel> rooms = hotelRepository.findAll();
			System.out.println(request.getSession().getAttribute("customerId"));
			
			// sending both lists to the reservation list page
			model.addAttribute("rooms", rooms);
			model.addAttribute("reservations", reservations);
			return "reservation_list";	
		}  
		
		model.addAttribute("error", "Please Sign in to book reservations");
		return "redirect:/index";	
	}
	
	// deletes the reservation and validates if the reservation is within two days from now
	@RequestMapping(value = "/deleteReservation", method = RequestMethod.POST)
	public String deleteReservation(@RequestParam("id") int id, Model model, HttpServletRequest request) throws ParseException {
		// get the reservation by ID
		Optional<Reservation> optionalReservation = reservationRepository.findById(id);
		
		// if the reservation present assign it to reseration object
		if (optionalReservation.isPresent()) {
			Reservation reservation = optionalReservation.get();
			
			// get today's date
			Date todayDate = new Date();
			
			// gets the arrival date in Date object
			Date arrivalDate = reservation.getNonFormattedArrivalDate();
			
			// gets the time difference between the two dates in milliseconds
			long difference = arrivalDate.getTime() - todayDate.getTime();
			
			// converting milliseconds to days
			long daysDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
			System.out.println(daysDifference);
			
			// checking if the user is deleting the reservation more than 2 days before the 
			// arrival date
			if (daysDifference > 2) {
				reservationRepository.deleteById(id);
				return "redirect:/showReservations";
			} else {
				// same logic from show reservations to show the error at the end
				if (request.getSession().getAttribute("customerId") != null) {
					int customerId = (int) request.getSession().getAttribute("customerId");
					List<Reservation> reservations = reservationRepository.findByCustomerId(customerId);
					for (Reservation res : reservations) {
						int roomId = res.getRoomId();
						Optional<Hotel> optionalRoom = hotelRepository.findById(roomId);
						if (optionalRoom.isPresent()) {
							Hotel room = optionalRoom.get();
							res.setRoom(room);
						}
					}
					List<Hotel> rooms = hotelRepository.findAll();
					System.out.println(request.getSession().getAttribute("customerId"));
					model.addAttribute("rooms", rooms);
					model.addAttribute("reservations", reservations);
					
					// show the error is the date is less that 2 days from current date
					model.addAttribute("error", "The arrival date should be more than 2 days after the current date to delete reservation.");
					return "reservation_list";	
				} 
			}
		}
		
		return "redirect:/showReservations";
	}
	
	// function used for request mapping edit reservation post route
	@RequestMapping(value = "/editReservation", method = RequestMethod.POST)
	public String updateReservation(HttpServletRequest request, Model model, @RequestParam("id") int id,
			@RequestParam("arrivalDate") String arrivalDate, @RequestParam("roomId") int roomId,
			@RequestParam("departureDate") String departureDate, @RequestParam("totalNights") int numberOfNights,
			@RequestParam("totalGuests") int numberOfGuests) {
		
		// checking if the customer is signed in
		if (request.getSession().getAttribute("customerId") != null) {
			int customerId = (int) request.getSession().getAttribute("customerId");
			
			// getting the room by Id stored in the reservation to get its price
			Optional<Hotel> optRoom = hotelRepository.findById(roomId);
			if (optRoom.isPresent()) {
				Hotel room = optRoom.get();
				
				// making a new reservation object with reservation Id to be used in the update function
				Reservation reservation = new Reservation(id, customerId, roomId, arrivalDate, departureDate,
						numberOfNights, numberOfGuests);

				// calculating total amount
				double totalAmount = reservation.calculateTotalAmount(room.getPrice());
				reservation.setTotalAmount(totalAmount);
				System.out.println(totalAmount);

				// saving the reservationobject and database updates automatically if reservation already exists
				reservationRepository.save(reservation);
				
				return "redirect:/showReservations";
			}
			return "redirect:/showReservations";
		}

		model.addAttribute("error", "Please Sign in to book reservations");
		return "redirect:/index";
	}

	// for handling errors regarding database update or save in reservation controller
	@ExceptionHandler(DataIntegrityViolationException.class)
	public String errorHandler(HttpServletRequest req, Exception ex) {
		System.out.println(ex);
		return "redirect:/reservation_page";
	}
}
