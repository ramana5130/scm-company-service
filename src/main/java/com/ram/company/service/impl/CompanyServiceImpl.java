package com.ram.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.company.entity.Company;
import com.ram.company.repository.CompanyRepository;
import com.ram.company.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private CompanyRepository repo;

	@Override
	public Long createCompany(Company cob) {

		return repo.save(cob).getId();
	}

}
