package com.bingetgroup.ERP.enums;

public enum AllowanceType {
    TRANSPORT("transport"),
    MOBILECARD("mobileCard"),
    HOUSE("house");
    private String allowance;
    AllowanceType(String allowance){
        this.allowance=allowance;
    }

    @Override
    public String toString() {
        return this.allowance;
    }
}
