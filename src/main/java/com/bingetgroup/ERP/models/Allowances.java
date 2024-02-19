package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.AllowanceType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_allowance")
public class Allowances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private AllowanceType allowanceType;
    private double amount;
    private LocalDate date;
    private boolean isTaxable;
    private double taxableFrom;
    @OneToMany(mappedBy = "allowance")
    @JsonIgnore
    private List<Positions> positions;
    @ManyToMany(mappedBy = "allowances")
    @JsonIgnore
    private List<Payroll> payrolls;
}
