package com.spring.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.annotation.Transient;

/*
 * Submitted By: Anmoldeep Singh Gill
 * Student Number: 301044883
 * */

//Customer entity class - Model class
@Entity
@EnableAutoConfiguration
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue
	@Column(name="reservationid")
	private int reservationId;
	
	// configuring the foreign keys for customer id
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "customer_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
	@Column(name="customerid")
	private int customerId;
	
	// configuring the foreign keys for room id
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "room_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
	@Column(name="roomid")
	private int roomId;
	
	@Column(name="arrivaldate")
	private String arrivalDate;
	
	@Column(name="departuredate")
	private String departureDate;
	
	@Column(name="totalnights")
	private int totalNights;
	@Column(name="totalguests")
	private int totalGuests;
	@Column(name="totalamount")
	private double totalAmount;
	
	// not mapped by the database but used for storing room data when fetching the list
	// of reservations
	@Transient
	private transient Hotel room;
	
	public Reservation() {
		
	}

	public Reservation(int customerId, int roomId, int totalNights, int totalGuests,
			String arrivalDate, String departureDate) {
		super();
		this.customerId = customerId;
		this.roomId = roomId;
		this.totalNights = totalNights;
		this.totalGuests = totalGuests;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	// getters and setters
	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getTotalNights() {
		return totalNights;
	}

	public void setTotalNights(int totalNights) {
		this.totalNights = totalNights;
	}

	public double getTotalGuests() {
		return totalGuests;
	}

	public void setTotalGuests(int totalGuests) {
		this.totalGuests = totalGuests;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
		
	
	public Hotel getRoom() {
		return room;
	}

	public void setRoom(Hotel room) {
		this.room = room;
	}
	
	

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public double calculateTotalAmount(double price) {
		return price * Double.valueOf(this.totalNights);
	}
}
