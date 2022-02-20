package com.ram.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.company.entity.Company;
import com.ram.company.exception.CompanyNotFoundException;
import com.ram.company.service.ICompanyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyRestController {

	@Autowired
	private ICompanyService service;

	// 1. Create a company with Address having HAS-A relationship
	@PostMapping("/create")
	public ResponseEntity<String> createCompany(@RequestBody Company company) {

		log.info("ENTERED INTO SAVE METHOD");
		ResponseEntity<String> response = null;

		try {
			Long id = service.createCompany(company);
			response = ResponseEntity.ok("CREATED WITH ID : " + id);
			log.info("COMPANY IS CREATED {}.", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("ABOUT TO LEAVE SAVE METHOD");
		return response;
	}

	// 2 . Get All Companies
	@GetMapping("/all")
	public ResponseEntity<List<Company>> getAllCompanies() {
		ResponseEntity<List<Company>> response = null;
		log.info("ENTERED INTO FETCH ALL METHOD");
		try {
			List<Company> list = service.getAllCompanies();
			response = ResponseEntity.ok(list);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("ABOUT TO LEAVE FETCH ALL METHOD");
		return response;
	}

	// 3. FETCH one company
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Company> getOneCompnay(@PathVariable Long id) {

		ResponseEntity<Company> response = null;
		log.info("ENTERED INTO FETCH SINGLE COMPANY METHOD");
		try {
			Company company = service.getOneCompany(id);
			response = ResponseEntity.ok(company);

		} catch (CompanyNotFoundException ce) {
			log.error(ce.getMessage());
			throw ce;
		}
		log.info("ABOUT TO LEAVE FETCH ONE METHOD");
		return response;
	}

}
