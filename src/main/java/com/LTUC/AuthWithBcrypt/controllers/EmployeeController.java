package com.LTUC.AuthWithBcrypt.controllers;

import com.LTUC.AuthWithBcrypt.repositories.EmployeeJpa;

public class EmployeeController {

    private EmployeeJpa employeeJpa;

    public EmployeeController(EmployeeJpa employeeJpa) {
        this.employeeJpa = employeeJpa;
    }

}