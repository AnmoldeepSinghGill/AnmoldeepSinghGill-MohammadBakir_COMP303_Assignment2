package com.spring.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Submitted By: Anmoldeep Singh Gill, Mohammad Bakir
 * Student Number: 301044883, 300987420
 * Submission date: 12th March 2021
 * */

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	public List<Reservation> findByCustomerId(int customerid);
}
