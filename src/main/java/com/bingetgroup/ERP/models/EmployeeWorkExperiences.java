package com.bingetgroup.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_work_experience")
public class EmployeeWorkExperiences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CompanyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalDuration;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;
}
