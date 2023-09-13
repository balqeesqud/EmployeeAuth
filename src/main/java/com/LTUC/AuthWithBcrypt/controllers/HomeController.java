package com.LTUC.AuthWithBcrypt.controllers;

import com.LTUC.AuthWithBcrypt.models.EmployeeUser;
import com.LTUC.AuthWithBcrypt.repositories.EmployeeJpa;
import com.LTUC.AuthWithBcrypt.repositories.PostsJpa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Scanner;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String getHomePage(){
        return "index.html";
    }

    @GetMapping("/securedHome")
    public String getHomeSecuredPage(HttpServletRequest request, Model model){
        HttpSession session= request.getSession();
        String username= session.getAttribute("username").toString();
        model.addAttribute("username", username);

        return "indexAfterLogging.html";
    }


    @GetMapping("/about")
    public String getAboutPage(){
        return "about.html";
    }


@GetMapping("/employee")
public String employeePage(){
    return "employee.html";
}


}
