package com.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Submitted By: Anmoldeep Singh Gill
 * Student Number: 301044883
 * */

//Customer entity class - Model class
@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@Column(name="reservationid")
	private int reservationId;
	@Column(name="customerid")
	private int customerId;
	@Column(name="roomid")
	private int roomId;
	@Column(name="totalnights")
	private double totalNights;
	@Column(name="totalguests")
	private double totalGuests;
	@Column(name="totalamount")
	private double totalAmount;
	
	public Reservation() {
		
	}

	public Reservation(int reservationId, int customerId, int roomId, double totalNights, double totalGuests,
			double totalAmount) {
		super();
		this.reservationId = reservationId;
		this.customerId = customerId;
		this.roomId = roomId;
		this.totalNights = totalNights;
		this.totalGuests = totalGuests;
		this.totalAmount = totalAmount;
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

	public void setTotalNights(double totalNights) {
		this.totalNights = totalNights;
	}

	public double getTotalGuests() {
		return totalGuests;
	}

	public void setTotalGuests(double totalGuests) {
		this.totalGuests = totalGuests;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
