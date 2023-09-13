package com.LTUC.AuthWithBcrypt.controllers;

import com.LTUC.AuthWithBcrypt.models.EmployeeUser;
import com.LTUC.AuthWithBcrypt.models.UserPosts;
import com.LTUC.AuthWithBcrypt.repositories.EmployeeJpa;
import com.LTUC.AuthWithBcrypt.repositories.PostsJpa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private EmployeeJpa employeeJpa;
    private PostsJpa postsJpa;

    public HomeController(EmployeeJpa employeeJpa, PostsJpa postsJpa) {
        this.employeeJpa = employeeJpa;
        this.postsJpa = postsJpa;
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "index.html";
    }


//
//
//            m.addAttribute("userPosts", userPosts);
//

    @GetMapping("/securedHome")
    public String getHomeSecuredPage(HttpServletRequest request, Model model){
    HttpSession session= request.getSession();
    String username= session.getAttribute("username").toString();
    model.addAttribute("username", username);

        EmployeeUser employeeUserInDb= employeeJpa.findByUsername(username);
        List<UserPosts> userPosts = employeeUserInDb.getPosts();
        model.addAttribute("userPosts", userPosts);

    return "indexAfterLogging.html";



//        @GetMapping("/securedHome")
//        public String getHomeSecuredPage(HttpServletRequest request, Model model){
//            HttpSession session= request.getSession();
//            String username= session.getAttribute("username").toString();
//            model.addAttribute("username", username);
//
//
//            EmployeeUser userFromDb = employeeJpa.findByUsername(username);
//            List<UserPosts> userPosts = userFromDb.getPosts();
//            model.addAttribute("userPosts", userPosts);
//
//            return "indexAfterLogging.html";
//        }
}


    @GetMapping("/about")
    public String getAboutPage(){
        return "about.html";
    }

    @GetMapping("/employee")
    public String employeePage(Model model){
        List<UserPosts> userPosts = postsJpa.findAll();
        model.addAttribute("userPosts", userPosts);
        return "indexAfterLogging.html";

}


}
