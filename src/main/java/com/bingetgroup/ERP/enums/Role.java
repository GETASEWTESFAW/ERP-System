package com.bingetgroup.ERP.enums;

public enum Role {
    USER("user"),
    HR("HR"),
    EMPLOYEE("employee"),
    MANAGER("manager");
    private final String role;
    Role(String role){
        this.role=role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
