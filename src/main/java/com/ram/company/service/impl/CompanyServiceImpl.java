package com.ram.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.company.entity.Company;
import com.ram.company.exception.CompanyNotFoundException;
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

	@Override
	public void updateCompany(Company com) {
		if (com.getCregId() != null && repo.existsById(com.getId())) {
			repo.save(com);
		}

	}

	@Override
	public Company getOneCompany(Long id) {
		Optional<Company> opt = repo.findById(id);
		if (opt.isEmpty()) {
			throw new CompanyNotFoundException("Given '" + id + "' Not exist");
		} else {
			return opt.get();
		}
	}

	@Override
	public List<Company> getAllCompanies() {

		return repo.findAll();
	}

}
