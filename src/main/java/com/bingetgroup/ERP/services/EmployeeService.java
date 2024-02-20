package com.bingetgroup.ERP.services;

import com.bingetgroup.ERP.dto.EducationBackground;
import com.bingetgroup.ERP.dto.Employee;
import com.bingetgroup.ERP.dto.EmployeeWorkExperience;
import com.bingetgroup.ERP.exception.UserNotFoundException;
import com.bingetgroup.ERP.models.EducationBackgrounds;
import com.bingetgroup.ERP.models.EmployeeWorkExperiences;
import com.bingetgroup.ERP.models.Employees;
import com.bingetgroup.ERP.repositories.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeesRepository employeesRepository;
    private final EmployeeWorkExperienceService employeeWorkExperienceService;
    private final EducationBackgroundService educationBackgroundService;
    private final CompanyService companyService;
    public String add(Employee employees){
        Employees employee=new Employees();
        employee.setEmail(employees.getEmail());
        employee.setEmploymentStatus(employees.getEmploymentStatus());
        employee.setFullName(employees.getFullName());
        employee.setMartialStatus(employees.getMartialStatus());
        employee.setMobileNumber(employees.getMobileNumber());
        employee.setCity(employees.getCity());
        employee.setSubcity(employees.getSubcity());
        employee.setWereda(employees.getWereda());
        employee.setPhoto(employees.getPhoto());
        employee.setBankAccount(employees.getBankAccount());
        employee.setDateOfHire(LocalDate.parse(employees.getDateOfHire()));
        employee.setGender(employees.getGender());
        //for future use
//        if (employees.getCompanyId() !=null && !employees.getCompanyId().isEmpty()){
//            Long companyId=Long.parseLong(employees.getCompanyId());
//            Company company=this.companyService.getCompanyById(companyId);
//            employee.setCompany(company);
//        }

        //position
        List<EducationBackground> educationBackgroundList=employees.getEducationBackgrounds();
        List<EducationBackgrounds> educationBackgrounds=educationBackgroundList.stream().map((edb)->{
            EducationBackgrounds eb=new EducationBackgrounds();
            eb.setEmployee(employee);
            eb.setInstitution(edb.getInstitution());
            eb.setEducationDuration(edb.getEducationDuration());
            eb.setFieldOfStudy(edb.getFieldOfStudy());
            eb.setStartedDate(LocalDate.parse(edb.getStartedDate()));
            eb.setEndDate(LocalDate.parse(edb.getEndDate()));
            eb.setEducationCertificate(edb.getEducationCertificate());
            return eb;
        }).toList();
        employee.setEducationBackgrounds(educationBackgrounds);

        List<EmployeeWorkExperience> employeeWorkExperienceList= employees.getEmployeeWorkExperiences();
        List<EmployeeWorkExperiences> employeeWorkExperiencesList=employeeWorkExperienceList.stream().map((exs) -> {
            EmployeeWorkExperiences ee=new EmployeeWorkExperiences();
            ee.setEmployee(employee);
            ee.setStartDate(LocalDate.parse(exs.getStartDate()));
            ee.setEndDate(LocalDate.parse(exs.getEndDate()));
            ee.setCompanyName(exs.getCompanyName());
            ee.setTotalDuration(exs.getTotalDuration());
            return ee;
        }).toList();

        employee.setEmployeeWorkExperiences(employeeWorkExperiencesList);
        this.employeesRepository.save(employee);
        this.educationBackgroundService.addAll(employee.getEducationBackgrounds());
        this.employeeWorkExperienceService.addAll(employee.getEmployeeWorkExperiences());

        return "Employee is registered Successfully";
    }
    public Employees getEmployeeById(Long id){
        return this.employeesRepository.findById(id).orElseThrow(()->new UserNotFoundException("Employee data is not found"));
    }
    public Employees getEmployeeByEmail(String email){
        return this.employeesRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("Employee data is not found"));
    }

    public List<Employees> getAllEmployees(int page,int size,String sortby){

        Pageable pageable= PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,sortby));
        return this.employeesRepository.findAll(pageable).getContent();
    }
    public List<Employees> getAllEmployees(){

        return this.employeesRepository.findAll();
    }
    public String update(Employee employees){
        String email=employees.getEmail();
        Employees employee=getEmployeeByEmail(email);
        employee.setEmploymentStatus(employees.getEmploymentStatus());
        employee.setFullName(employees.getFullName());
        employee.setMartialStatus(employees.getMartialStatus());
        employee.setMobileNumber(employees.getMobileNumber());
        employee.setCity(employees.getCity());
        employee.setBankAccount(employees.getBankAccount());
        employee.setDateOfHire(LocalDate.parse(employees.getDateOfHire()));
        employee.setGender(employees.getGender());

        List<EducationBackground> educationBackgroundList=employees.getEducationBackgrounds();
        List<EducationBackgrounds> educationBackgrounds=educationBackgroundList.stream().map((edb)->{
            EducationBackgrounds eb=new EducationBackgrounds();
            eb.setInstitution(edb.getInstitution());
            eb.setEducationDuration(edb.getEducationDuration());
            eb.setFieldOfStudy(edb.getFieldOfStudy());
            eb.setStartedDate(LocalDate.parse(edb.getStartedDate()));
            eb.setEndDate(LocalDate.parse(edb.getEndDate()));
            eb.setEducationCertificate(edb.getEducationCertificate());
            return eb;
        }).toList();
        employee.setEducationBackgrounds(educationBackgrounds);

        List<EmployeeWorkExperience> employeeWorkExperienceList= employees.getEmployeeWorkExperiences();
        List<EmployeeWorkExperiences> employeeWorkExperiencesList=employeeWorkExperienceList.stream().map((exs) -> {
            EmployeeWorkExperiences ee=new EmployeeWorkExperiences();
            ee.setStartDate(LocalDate.parse(exs.getStartDate()));
            ee.setEndDate(LocalDate.parse(exs.getEndDate()));
           ee.setCompanyName(exs.getCompanyName());
           ee.setTotalDuration(exs.getTotalDuration());
           return ee;
        }).toList();

        employee.setEmployeeWorkExperiences(employeeWorkExperiencesList);
       // List<EducationBackground> educationBackground=employees.getEducationBackgrounds();
         this.employeesRepository.save(employee);
        this.educationBackgroundService.updateAll(employee.getEducationBackgrounds());
        this.employeeWorkExperienceService.updateAll(employee.getEmployeeWorkExperiences());
        return "employee data is updated successfully";
    }
    public String delete(Employees employees){
        this.employeesRepository.delete(employees);
        this.employeeWorkExperienceService.deleteAll(employees.getEmployeeWorkExperiences());
        this.educationBackgroundService.deleteAll(employees.getEducationBackgrounds());
        return "Employee is deleted successfully";
    }
    public String delete(String ids){
        Long id=Long.parseLong(ids);
        Employees employees=getEmployeeById(id);
        this.employeesRepository.deleteById(id);
        this.employeeWorkExperienceService.deleteAll(employees.getEmployeeWorkExperiences());
        this.educationBackgroundService.deleteAll(employees.getEducationBackgrounds());
        return "Employee is deleted successfully";
    }
}
