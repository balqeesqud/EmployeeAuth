package com.LTUC.AuthWithBcrypt.repositories;

import com.LTUC.AuthWithBcrypt.models.EmployeeUser;
import com.LTUC.AuthWithBcrypt.models.UserPosts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsJpa extends JpaRepository<UserPosts, Long> {
    List<UserPosts> findByUser(EmployeeUser user);
}
