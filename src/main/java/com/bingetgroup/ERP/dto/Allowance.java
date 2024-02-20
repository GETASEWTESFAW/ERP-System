package com.bingetgroup.ERP.dto;

import com.bingetgroup.ERP.enums.AllowanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allowance {
    private String id;
    private AllowanceType allowanceType;
    private double amount;
    private String date;
    private boolean isTaxable;
    private double taxableFrom;
    private String companyId;
}
