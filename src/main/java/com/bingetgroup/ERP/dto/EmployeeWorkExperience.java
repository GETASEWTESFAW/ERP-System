package com.bingetgroup.ERP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWorkExperience {
    private String CompanyName;
    private String startDate;
    private String endDate;
    private Double totalDuration;
//    private Employees employee;
}
