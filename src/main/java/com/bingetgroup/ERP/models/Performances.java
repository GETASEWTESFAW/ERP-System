package com.bingetgroup.ERP.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Date performanceDateFrom;
    private Date performanceDateTo;
    private String remark;
    private Employees employees;
}
