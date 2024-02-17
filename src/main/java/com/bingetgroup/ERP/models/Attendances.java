package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.AttendanceValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_attendance")
public class Attendances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date year;
    private Date month;
    private Data date;
    private AttendanceValue attendanceValue;
    @ManyToMany
    private Employees employee;

}