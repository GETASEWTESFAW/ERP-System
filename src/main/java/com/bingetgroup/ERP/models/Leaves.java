package com.bingetgroup.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_leave")
public class Leaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Leaves leaveType;
    private double totalLeave;
    private double leaveUsed;
    private double leaveBalance;
    @ManyToMany(mappedBy = "id")
    private Employees employee;
    private Date year;
}
