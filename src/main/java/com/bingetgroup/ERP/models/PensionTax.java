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
@Table(name = "pension_tax")
public class PensionTax implements TaxType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taxName;
    private double rate;
    private boolean isFromEmployee;
}
