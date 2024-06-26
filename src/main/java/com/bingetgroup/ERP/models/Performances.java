package com.bingetgroup.ERP.models;

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
@Table(name = "employee_performance")
public class Performances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double workQuality;
    private double workKnowledge;
    private double speed;
    private double responsibility;
    private double leaderShip;
    private double attendance;
    private double resourceEfficiencyAndProtection;
    private double initiativeAndCreativity;
    private LocalDate performanceDateFrom;
    private LocalDate performanceDateTo;
    private String remark;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;
}
