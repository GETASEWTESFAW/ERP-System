package com.bingetgroup.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;
    private LocalDate authorizedDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name="payroll_id"),
    inverseJoinColumns = @JoinColumn(name = "allowance_id"))
    private List<Allowances> allowances;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_rate_id")
    private IncomeTaxRates taxRates;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name="payroll_id"),
            inverseJoinColumns = @JoinColumn(name = "other_payable_tax_id"))
    private List<OtherTaxPayable> otherTaxPayable;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "overtime_id")
    private List<Overtimes> overtimes;
    @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "pension_tax_id")
    private PensionTax pensionTax;
    private double totalEarning;
    private double taxableIncome;
    private double incomeTax;
    private double loanOrAbsent;
    private double totalDeductions;
    private double netPay;
    @ManyToOne
    @JoinColumn(name = "prepared_by")
    private Employees preparedBy;
    @ManyToOne
    @JoinColumn(name = "checked_by")
    private Employees checkedBy;

}
