package com.bingetgroup.ERP.enums;

public enum AttendanceValue {
    ABSENT("absent"),
    PRESENT("present"),
    Late("excuse"),
    LEAVE("leave");
    private final String attendanceValue;
    AttendanceValue(String value){
         this.attendanceValue=value;
    }

    @Override
    public String toString() {
        return this.attendanceValue;
    }
}
