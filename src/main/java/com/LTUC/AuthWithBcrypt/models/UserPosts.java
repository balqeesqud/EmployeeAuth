package com.LTUC.AuthWithBcrypt.models;

import javax.persistence.*;

@Entity
public class UserPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String textContent;
    @ManyToOne
    private EmployeeUser userId; // one Employee may create many posts // it was as post not userId

    public UserPosts() {
    }


//    public UserPosts(Long userId, String textContent, EmployeeUser post) {
//        this.userId = userId;
//        this.textContent = textContent;
//        this.post = post;
//    }

    public UserPosts( String textContent) {
        this.textContent = textContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public EmployeeUser getUserId() {
        return userId;
    }

    public void setUserId(EmployeeUser userId) {
        this.userId = userId;
    }



}
