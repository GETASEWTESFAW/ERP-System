package com.bingetgroup.ERP.services;

import com.bingetgroup.ERP.exception.RecordNotFoundException;
import com.bingetgroup.ERP.models.Companies;
import com.bingetgroup.ERP.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    public Companies getCompanyById(Long id){
        return this.companyRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Company record is not found."));
    }
    public String add(Companies company){
        this.companyRepository.save(company);
        return "Company is recorded successfully.";
    }
}
