package com.bingetgroup.ERP.enums;

public enum RequestStatus {
    APPROVED("approved"),
    REJECTED("rejected");
    private final String status;
    RequestStatus(String status){
        this.status=status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
