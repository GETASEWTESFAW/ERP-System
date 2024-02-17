package com.bingetgroup.ERP.enums;

public enum AttendanceValue {
    ABSENT("absent"),
    PRESENT("present"),
    EXCUSE("excuse"),
    LEAVE("leave");
    private String attendanceValue;
    AttendanceValue(String value){
         this.attendanceValue=value;
    }

    @Override
    public String toString() {
        return this.attendanceValue;
    }
}
