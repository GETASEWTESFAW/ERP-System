package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.EmploymentStatus;
import com.bingetgroup.ERP.enums.Gender;
import com.bingetgroup.ERP.enums.MartialStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
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
    @NotBlank(message = "email is mandatory, please fill the correct email.")
    @Email
    private String email;
    private Gender gender;
    private String mobileNumber;
    private String city;
    private String subcity;
    private String wereda;
    private String photo;
    private LocalDate dateOfHire;
    private String bankAccount;
    @Enumerated(EnumType.STRING)
    private MartialStatus martialStatus;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Positions position;
    @OneToMany(mappedBy = "employee")
    private List<EmployeeWorkExperience> employeeWorkExperiences;
    @OneToMany(mappedBy = "employee")
    private List<EducationBackground> educationBackgrounds;
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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
