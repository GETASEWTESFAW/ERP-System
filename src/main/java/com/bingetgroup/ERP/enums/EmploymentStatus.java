package com.bingetgroup.ERP.enums;

public enum EmploymentStatus {
    RETIRE("retire"),
    TERMINATE("terminate"),
    FIRED("FIRED"),
    ACTIVE("ACTIVE");
    private final String employmentStatus;
    EmploymentStatus(String status){
        this.employmentStatus=status;
    }

    @Override
    public String toString() {
        return this.employmentStatus;
    }
}
