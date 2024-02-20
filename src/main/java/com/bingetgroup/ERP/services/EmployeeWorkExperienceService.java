package com.bingetgroup.ERP.services;

import com.bingetgroup.ERP.exception.RecordNotFoundException;
import com.bingetgroup.ERP.models.EmployeeWorkExperiences;
import com.bingetgroup.ERP.models.Employees;
import com.bingetgroup.ERP.repositories.EmployeeWorkExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeWorkExperienceService {
    private final EmployeeWorkExperienceRepository employeeWorkExperienceRepository;

    public EmployeeWorkExperiences getEmployeeWorkExperienceById(Long id){
        return this.employeeWorkExperienceRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Employee work experience is not found for the given employee"));
    }
    public List<EmployeeWorkExperiences> getAllEmployeeWorkExperience(int page, int size, String column){
        Sort sort=Sort.by(column).ascending();
        Pageable pageable= PageRequest.of(page,size,sort);
        return this.employeeWorkExperienceRepository.findAll(pageable).getContent();
    }
    public EmployeeWorkExperiences getEmployeeWorkExperienceByEmployee(Employees employees){
        return this.employeeWorkExperienceRepository.findByEmployee(employees).orElseThrow(()->new RecordNotFoundException("Employee work experience is not found for the given employee"));
    }

    public String add(EmployeeWorkExperiences employeeWorkExperience){
        this.employeeWorkExperienceRepository.save(employeeWorkExperience);
        return "Employee WorkExperience is recorded successfully";
    }
    public String addAll(List<EmployeeWorkExperiences> employeeWorkExperiences){
        this.employeeWorkExperienceRepository.saveAll(employeeWorkExperiences);
        return "Employee WorkExperiences are recorded successfully";
    }
    public String delete(EmployeeWorkExperiences employeeWorkExperience){
        this.employeeWorkExperienceRepository.delete(employeeWorkExperience);
        return "Employee WorkExperience is recorded successfully";
    }
    public String deleteAll(List<EmployeeWorkExperiences> employeeWorkExperiences){
        this.employeeWorkExperienceRepository.deleteAll(employeeWorkExperiences);
        return "Employee WorkExperiences are recorded successfully";
    }
   public String update(EmployeeWorkExperiences employeeWorkExperience){
        EmployeeWorkExperiences employeeWorkExperience1=getEmployeeWorkExperienceById(employeeWorkExperience.getId());
       employeeWorkExperience1.setCompanyName(employeeWorkExperience.getCompanyName());
       employeeWorkExperience1.setStartDate(employeeWorkExperience.getStartDate());
       employeeWorkExperience1.setEndDate(employeeWorkExperience.getEndDate());
       employeeWorkExperience1.setTotalDuration(employeeWorkExperience.getTotalDuration());
        return "Employee WorkExperience is update successfully";
   }

   public String updateAll(List<EmployeeWorkExperiences> employeeWorkExperiences){
       employeeWorkExperiences.stream().map((employeeWorkExperience)->update(employeeWorkExperience)).collect(Collectors.toList());
       return "Employee WorkExperiences are updated successfully";
   }

}
