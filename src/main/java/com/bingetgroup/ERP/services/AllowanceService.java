package com.bingetgroup.ERP.services;

import com.bingetgroup.ERP.dto.Allowance;
import com.bingetgroup.ERP.enums.AllowanceType;
import com.bingetgroup.ERP.exception.RecordNotFoundException;
import com.bingetgroup.ERP.models.Allowances;
import com.bingetgroup.ERP.models.Companies;
import com.bingetgroup.ERP.repositories.AllowancesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AllowanceService {
    private final AllowancesRepository allowancesRepository;
    private final CompanyService companyService;
    public Allowances getAllowanceById(Long id){
        return this.allowancesRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Allowance is not found!"));
    }
    public List<Allowances> getAllAllowance(int page, int size, String column){
        Sort sort=Sort.by(column).ascending();
        Pageable pageable= PageRequest.of(page,size);
        return this.allowancesRepository.findAll(pageable).getContent();
    }
  public Allowances getAllowanceByAllowanceType(AllowanceType allowanceType){
      return this.allowancesRepository.findByAllowanceType(allowanceType).orElseThrow(()->new RecordNotFoundException("Allowance record is not found"));
  }
    public String add(Allowance allowances){
        Allowances allowances1=new Allowances();
        allowances1.setAllowanceType(allowances.getAllowanceType());
        allowances1.setAllowanceType(allowances.getAllowanceType());
        allowances1.setAmount(allowances.getAmount());
        allowances1.setDate(LocalDate.parse(allowances.getDate()));
        if (allowances.getCompanyId() !=null && !allowances.getCompanyId().isEmpty()){
            Long companyId=Long.parseLong(allowances.getCompanyId());
            Companies company =this.companyService.getCompanyById(companyId);
            allowances1.setCompany(company);
        }
        allowances1.setTaxable(allowances.isTaxable());
        allowances1.setTaxableFrom(allowances.getTaxableFrom());
        this.allowancesRepository.save(allowances1);
        return "Allowance is recorded successfully";
    }
    public String update(Allowance allowances){
        Allowances allowances1=getAllowanceById(Long.parseLong(allowances.getId()));
        allowances1.setAllowanceType(allowances.getAllowanceType());
        allowances1.setAmount(allowances.getAmount());
        allowances1.setDate(LocalDate.parse(allowances.getDate()));
        if (allowances.getCompanyId() !=null && !allowances.getCompanyId().isEmpty()){
            Long companyId=Long.parseLong(allowances.getCompanyId());
            Companies company =this.companyService.getCompanyById(companyId);
            allowances1.setCompany(company);
        }

        allowances1.setTaxable(allowances.isTaxable());
        allowances1.setTaxableFrom(allowances.getTaxableFrom());
        this.allowancesRepository.save(allowances1);
        return "Allowance is updated successfully";
    }
    public String delete(Allowances allowances){
        this.allowancesRepository.delete(allowances);
        return "Allowance is updated successfully";
    }

    public String delete(String allowanceId){
        this.allowancesRepository.deleteById(Long.parseLong(allowanceId));
        return "Position is deleted successfully";
    }
}
