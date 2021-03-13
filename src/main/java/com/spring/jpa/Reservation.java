package com.spring.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private Date arrivalDate;
	
	@Column(name="departuredate")
	private Date departureDate;
	
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
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.arrivalDate = simpleDateFormat.parse(arrivalDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.departureDate = simpleDateFormat.parse(departureDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public Reservation(int reservationId, int customerId, int roomId, String arrivalDate, String departureDate,
			int totalNights, int totalGuests) {
		super();
		this.reservationId = reservationId;
		this.customerId = customerId;
		this.roomId = roomId;
		this.totalNights = totalNights;
		this.totalGuests = totalGuests;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.arrivalDate = simpleDateFormat.parse(arrivalDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.departureDate = simpleDateFormat.parse(departureDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public int getTotalNights() {
		return (int) totalNights;
	}

	public void setTotalNights(int totalNights) {
		this.totalNights = totalNights;
	}

	public int getTotalGuests() {
		return (int) totalGuests;
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(this.arrivalDate);
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(this.departureDate);
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public double calculateTotalAmount(double price) {
		return price * Double.valueOf(this.totalNights);
	}
	
	public Date getNonFormattedDepartureDate() {
		return departureDate;
	}
	
	public Date getNonFormattedArrivalDate() {
		return arrivalDate;
	}
}
