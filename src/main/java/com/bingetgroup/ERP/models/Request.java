package com.bingetgroup.ERP.models;

import com.bingetgroup.ERP.enums.Status;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Request {
    private Employees employee;
    private LocalDate requestedDate;
    private LocalDate approvedDate;
    private Status status;
}
