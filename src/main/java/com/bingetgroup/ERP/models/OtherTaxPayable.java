package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.interfeces.TaxType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "other_tax_payable")
public class OtherTaxPayable implements TaxType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taxName;
    private boolean isPercentage;
    private double rate;
}
