package com.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/*
 * Submitted By: Anmoldeep Singh Gill, Mohammad Bakir
 * Student Number: 301044883, 300987420
 * Submission date: 12th March 2021
 * */

//Hotel entity class - Model class
@Entity
@EnableAutoConfiguration
@Table(name="hotel")
public class Hotel {
	
	@Id
	@GeneratedValue
	@Column(name="roomid")
	private int roomId;
	@Column(name="roomtype")
	private String roomType;
	@Column(name="price")
	private double price;
	@Column(name="roomimage")
	private String roomImage;
	
	public Hotel() {
		
	}

	// constructor
	public Hotel(int roomId, String roomType, double price, String roomImage) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.roomImage = roomImage;
	}

	// getters an setters
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(String roomImage) {
		this.roomImage = roomImage;
	}
	
	
}
