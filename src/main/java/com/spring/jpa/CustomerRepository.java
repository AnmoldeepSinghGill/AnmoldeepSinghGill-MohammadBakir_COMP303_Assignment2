package com.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Submitted By: Anmoldeep Singh Gill, Mohammad Bakir
 * Student Number: 301044883, 300987420
 * Submission date: 12th March 2021
 * */

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public Customer findByEmail(String email);
}


