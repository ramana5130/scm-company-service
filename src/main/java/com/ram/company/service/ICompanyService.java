package com.ram.company.service;

import java.util.List;

import com.ram.company.entity.Company;

public interface ICompanyService {

	Long createCompany(Company cob);

	void updateCompany(Company cob);

	Company getOneCompany(Long id);

	List<Company> getAllCompanies();

}
