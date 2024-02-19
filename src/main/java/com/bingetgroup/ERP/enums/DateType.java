package com.bingetgroup.ERP.enums;

public enum DateType {
    HOLY_DAY("holyDay"),WEEK_DAY1("Week_day1(5:00 PM-10:00 PM)"),WEEK_DAY2("Week_day1(10:00 PM-6:00 AM)"),WEEKEND_DAY("Weekend_day");
   private final String dateType;
    DateType(String dateType){
        this.dateType=dateType;
    }

    @Override
    public String toString() {
        return this.dateType;
    }
}
