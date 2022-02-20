package com.ram.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.company.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
