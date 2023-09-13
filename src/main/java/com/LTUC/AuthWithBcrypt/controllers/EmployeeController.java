package com.LTUC.AuthWithBcrypt.controllers;

import com.LTUC.AuthWithBcrypt.models.EmployeeUser;
import com.LTUC.AuthWithBcrypt.repositories.EmployeeJpa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeJpa employeeJpa;

    public EmployeeController(EmployeeJpa employeeJpa) {
        this.employeeJpa = employeeJpa;
    }

//    @PostMapping("/add-employee")
//    public RedirectView addEmployee(String username, String password) {
//        EmployeeUser employee = new EmployeeUser(username, password);
//        employeeJpa.save(employee);
//        return new RedirectView("/employee");
//
//    }

    @GetMapping("/employee")
    public String getAllUsers(Model model) {
        List<EmployeeUser> users =  employeeJpa.findAll();
        model.addAttribute("employees", users);
        return "employee.html";
    }


}
