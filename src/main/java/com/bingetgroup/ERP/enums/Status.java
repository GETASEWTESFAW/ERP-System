package com.bingetgroup.ERP.enums;

public enum Status {
    APPROVED("approved"),
    REJECTED("rejected");
    private final String status;
    Status(String status){
        this.status=status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
