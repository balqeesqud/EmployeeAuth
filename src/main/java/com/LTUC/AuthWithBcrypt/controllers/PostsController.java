package com.LTUC.AuthWithBcrypt.controllers;

import com.LTUC.AuthWithBcrypt.exception.EmployeeDoesNotExist;
import com.LTUC.AuthWithBcrypt.models.EmployeeUser;
import com.LTUC.AuthWithBcrypt.models.UserPosts;
import com.LTUC.AuthWithBcrypt.repositories.EmployeeJpa;
import com.LTUC.AuthWithBcrypt.repositories.PostsJpa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class PostsController {

    private EmployeeJpa employeeJpa;
    private PostsJpa postsJpa;

    public PostsController(EmployeeJpa employeeJpa, PostsJpa postsJpa) {
        this.employeeJpa = employeeJpa;
        this.postsJpa = postsJpa;
    }

//    @PostMapping("/create-post")
//    public RedirectView addPost(Long employeeUserId, String textContent) {
//        EmployeeUser employee = employeeJpa
//                .findById(employeeUserId)
//                .orElseThrow(() -> new EmployeeDoesNotExist("Could not find Employee with this post in the database!"));
//
//        UserPosts post = new UserPosts(employeeUserId, textContent, employee);
//        postsJpa.save(post);
//
//        return new RedirectView("/employee");
//    }

    @PostMapping("/create-post")
    public RedirectView addPost(HttpServletRequest request, String textContent) {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            EmployeeUser user = employeeJpa.findByUsername(username);

            if (user != null) {
                UserPosts post = new UserPosts(textContent);
                post.setUserId(user);

                postsJpa.save(post);
            }
        }

        return new RedirectView("/securedHome");
    }

//
//    Posts post = new Posts(postText);
//        post.setUserId(userFromDb);
//        postsRepo.save(post);
//
//        return new RedirectView("/homeAfterAuth");
//}
}




