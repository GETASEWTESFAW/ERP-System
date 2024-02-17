package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_leave_Request")
public class LeaveRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalLeaveRequested;
    private double totalLeaveApproved;
    private Date requestedFrom;
    private Date approvedTo;
    private Date reportDate;
    private Date requestedDate;
    private Date approvedDate;
    private String remark;
    private RequestStatus status;
    @ManyToMany(mappedBy = "id")
    private Employees employee;
}
