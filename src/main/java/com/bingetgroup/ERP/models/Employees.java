package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.EmploymentStatus;
import com.bingetgroup.ERP.enums.MartialStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee_profile")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String city;
    private String subcity;
    private String wereda;
    private String photo;
    @Enumerated(EnumType.STRING)
    private MartialStatus martialStatus;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;
    @ManyToOne
    private Positions position;
}
