package com.bingetgroup.ERP.services;

import com.bingetgroup.ERP.exception.UserNotFoundException;
import com.bingetgroup.ERP.models.Employees;
import com.bingetgroup.ERP.repositories.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeesRepository employeesRepository;
    public Employees add(Employees emp){
        return this.employeesRepository.save(emp);
    }
    public List<Employees> getAllEmployees(){
        return this.employeesRepository.findAll();
    }
    public Employees update(Employees employees){
        String email=employees.getEmail();
        Employees employee=this.employeesRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("Employee is not registord"));
        employee.setEmploymentStatus(employees.getEmploymentStatus());
        employee.setFullName(employees.getFullName());
        employee.setMartialStatus(employees.getMartialStatus());
        employee.setMobileNumber(employees.getMobileNumber());
        employee.setCity(employees.getCity());
        return employee;
    }
}
