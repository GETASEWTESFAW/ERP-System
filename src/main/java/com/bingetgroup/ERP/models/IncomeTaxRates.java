package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.IncomeLevel;
import com.bingetgroup.ERP.interfeces.TaxType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "income_tax_rate")
public class IncomeTaxRates implements TaxType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taxName;
    private IncomeLevel incomeLevel;
    private double incomeStart;
    private double endStart;
    private double rate;
    private double deduction;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
