package com.bingetgroup.ERP.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Employees> employees;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Allowances> allowances;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Positions> positions;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<IncomeTaxRates> incomeTaxRates;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<PensionTax> pensionTaxes;
}
