package com.bingetgroup.ERP.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomErrorResponse {


    private String message;
    private String timestamp;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(String message) {

        this.message = message;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    // Other constructors, getters, and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
