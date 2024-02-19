package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.DateType;
import com.bingetgroup.ERP.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "overtime")
public class Overtimes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate dutyDate;
  private LocalTime startingTime;
  private LocalTime endingTime;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
          joinColumns = @JoinColumn(name ="overtime_id"),
  inverseJoinColumns = @JoinColumn(name = "overtime_type_id"))
  private List<OvertimeTypes> overtimeTypes;
  private Status status;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "approved_by")
  private Employees approvedBy;
}
