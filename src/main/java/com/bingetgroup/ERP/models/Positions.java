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
@Table(name = "employee_position")
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String positionName;
    @ManyToOne
    @JoinColumn(name = "allowance_id")
    private Allowances allowance;
    @OneToMany(mappedBy = "position")
    @JsonIgnore
    private List<Employees> employees;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
