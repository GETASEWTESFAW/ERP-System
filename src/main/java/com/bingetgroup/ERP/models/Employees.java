package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.EmploymentStatus;
import com.bingetgroup.ERP.enums.MartialStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee_profile",
        uniqueConstraints = {@UniqueConstraint(name = "email_unique_constraint",columnNames = "email")})
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name",nullable = false)
    private String fullName;
    @Column(nullable = false)
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Positions position;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Attendances> attendances;
    @OneToMany(mappedBy = "requestedBy")
    @JsonIgnore
    private List<LeaveRequests> requestedLeave;
    @OneToMany(mappedBy = "approvedBy")
    @JsonIgnore
    private List<LeaveRequests> approvedBy;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Leaves> leaves;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Performances> performances;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<WorkExperienceRequests> workExperienceRequests;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Payroll> payrolls;
    @OneToMany(mappedBy = "preparedBy")
    @JsonIgnore
    private List<Payroll> PayrollPrepared;
    @OneToMany(mappedBy = "checkedBy")
    @JsonIgnore
    private List<Payroll> payrollApproved;
}
