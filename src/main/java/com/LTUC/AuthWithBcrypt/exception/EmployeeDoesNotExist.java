package com.LTUC.AuthWithBcrypt.exception;

public class EmployeeDoesNotExist extends RuntimeException{

    public EmployeeDoesNotExist(String message) {
        super(message);
    }


    public EmployeeDoesNotExist(Throwable cause) {
        super(cause);
    }
}

