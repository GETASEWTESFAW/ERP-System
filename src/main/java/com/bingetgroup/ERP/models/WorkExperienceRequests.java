package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_work_experience_request")
public class WorkExperienceRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date requestedDate;
    private RequestStatus status;
    @ManyToMany
    private Employees employee;
}
