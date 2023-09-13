package com.LTUC.AuthWithBcrypt.controllers;

import com.LTUC.AuthWithBcrypt.models.EmployeeUser;
import com.LTUC.AuthWithBcrypt.repositories.EmployeeJpa;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    private EmployeeJpa employeeJpa;

    public AuthController(EmployeeJpa employeeJpa) {
        this.employeeJpa = employeeJpa;
    }


    @GetMapping("/signup")
    public String getSignupPage() {
        return "/signup.html";
    }

    @PostMapping("/signup")
    public String signupUser(String username, String password) {
        String hashedPassword= BCrypt.hashpw(password,BCrypt.gensalt(12));
        EmployeeUser employee = new EmployeeUser(username, hashedPassword);
        employeeJpa.save(employee);
        return "/login.html";
    }

//==========================================================================================================
    @GetMapping("/login")
    public String getLoginPage() {
        return "/login.html";
    }


    @PostMapping("/login")
    public RedirectView loggedInUser(HttpServletRequest request, String username, String password){
        EmployeeUser employeeInDB = employeeJpa.findByUsername(username);

        if((employeeInDB == null)
                || !(BCrypt.checkpw(password, employeeInDB.getPassword())))
        {
            return new RedirectView("/login");
        }
        HttpSession httpSession= request.getSession();
        httpSession.setAttribute("username", username);
        return new RedirectView("/securedHome");
    }

//=====================================================================================================

    @PostMapping("/logout")
    public RedirectView logoutUser(HttpServletRequest request){

        HttpSession session= request.getSession();
        session.invalidate();

        return new RedirectView("/login");
    }
    @GetMapping("/logout")
    public String getLogoutPage(){
        return "/login.html";
    }
}

