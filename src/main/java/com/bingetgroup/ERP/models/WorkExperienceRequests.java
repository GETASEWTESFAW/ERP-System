package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.Status;
import com.bingetgroup.ERP.interfeces.Request;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_work_experience_request")
public class WorkExperienceRequests implements Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate requestedDate;
    private LocalDate approvedDate;
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employees employee;
}
