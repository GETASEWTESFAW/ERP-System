package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.AttendanceValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_attendance")
public class Attendances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate year;
    private LocalDate month;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private AttendanceValue attendanceValue;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;

}
