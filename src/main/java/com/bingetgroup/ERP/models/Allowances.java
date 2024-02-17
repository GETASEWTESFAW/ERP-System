package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.AllowanceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_allowance")
public class Allowances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private AllowanceType allowanceType;
    private double amount;
    private Date date;
}
