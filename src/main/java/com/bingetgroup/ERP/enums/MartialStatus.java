package com.bingetgroup.ERP.enums;

public enum MartialStatus {
    SINGLE("single"),
    MARRIED("married"),
    DIVORCED("divorced"),
    WIDOWED("widowed"),
    OTHER("other");
    private final String martialStatus;
    MartialStatus(String status){
        this.martialStatus=status;
    }
    @Override
    public String toString() {
        return this.martialStatus;
    }
}
