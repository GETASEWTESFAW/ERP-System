package com.bingetgroup.ERP.dto;

import com.bingetgroup.ERP.models.Employees;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationBackground {
    private String institution;
    private String startedDate;
    private String endDate;
    private String educationDuration;
    private String educationCertificate;
    private String fieldOfStudy;

//    private Employees employee;
}
