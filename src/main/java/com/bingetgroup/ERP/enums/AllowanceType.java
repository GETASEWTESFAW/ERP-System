package com.bingetgroup.ERP.enums;

public enum AllowanceType {
    TRANSPORT("transport"),
    MOBILE_CARD("mobileCard"),
    HOUSE("house");
    private final String allowance;
    AllowanceType(String allowance){
        this.allowance=allowance;
    }

    @Override
    public String toString() {
        return this.allowance;
    }
}
