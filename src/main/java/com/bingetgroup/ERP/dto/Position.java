package com.bingetgroup.ERP.dto;

import com.bingetgroup.ERP.models.Allowances;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    private String id;
    private String positionName;
    private List<String> allowanceIds;
}
