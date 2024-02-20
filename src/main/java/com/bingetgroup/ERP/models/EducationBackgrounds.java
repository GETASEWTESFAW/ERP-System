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
@Table(name = "education_background")
public class EducationBackgrounds {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String institution;
 private LocalDate startedDate;
 private LocalDate endDate;
 private String educationDuration;
 private String educationCertificate;
 private String fieldOfStudy;
 @ManyToOne
 @JoinColumn(name = "employee_id")
 private Employees employee;

}
