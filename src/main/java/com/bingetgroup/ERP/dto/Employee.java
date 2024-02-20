package com.bingetgroup.ERP.dto;

import com.bingetgroup.ERP.enums.EmploymentStatus;
import com.bingetgroup.ERP.enums.Gender;
import com.bingetgroup.ERP.enums.MartialStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String fullName;
    private String email;
    private Gender gender;
    private String mobileNumber;
    private String city;
    private String subcity;
    private String wereda;
    private String photo;
    private String dateOfHire;
    private String bankAccount;
    private MartialStatus martialStatus;
    private EmploymentStatus employmentStatus;
    private Position position;
    private List<EmployeeWorkExperience> employeeWorkExperiences;
    private List<EducationBackground> educationBackgrounds;
    private String companyId;
}
