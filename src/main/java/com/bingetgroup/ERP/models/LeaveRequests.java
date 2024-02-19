package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_leave_Request")
public class LeaveRequests extends Request{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalLeaveRequested;
    private double totalLeaveApproved;
    private LocalDate requestedFrom;
    private LocalDate requestedTo;
    private LocalDate reportDate;
    private LocalDate requestedDate;
    private LocalDate approvedDate;
    private String remark;
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requested_by")
    private Employees requestedBy;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "approved_by")
    private Employees approvedBy;
}
