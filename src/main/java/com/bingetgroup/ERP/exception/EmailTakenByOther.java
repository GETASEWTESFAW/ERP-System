package com.bingetgroup.ERP.exception;

public class EmailTakenByOther extends RuntimeException {
    public EmailTakenByOther(String message){
        super(message);
    }
}
