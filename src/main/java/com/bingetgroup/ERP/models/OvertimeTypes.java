package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.DateType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "overtime_type")
public class OvertimeTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DateType dateType;
    private LocalTime startTime;
    private LocalTime endTime;
    private double rate;
    @ManyToMany(mappedBy = "overtimeTypes")
    @JsonIgnore
    private List<Overtimes> overtimes;

}
