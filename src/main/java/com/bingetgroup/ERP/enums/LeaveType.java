package com.bingetgroup.ERP.enums;

public enum LeaveType {
    ANNUALLEAVE("annalLive"),
    LEAVE_WITHOUT_PAY("leaveWithoutPay"),
    MARRIAGE_LEAVE("marriageLeave"),
    MOURNING_LEAVE("mourningLeave"),
    MAT_LEAVE("matLeave"),
    SPECIAL_LEAVE("specialLeave");
    private String leaveType;
    LeaveType(String leaveType){
        this.leaveType=leaveType;
    }

    @Override
    public String toString() {
        return this.leaveType;
    }
}
