package com.LTUC.AuthWithBcrypt.repositories;

import com.LTUC.AuthWithBcrypt.models.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpa extends JpaRepository<EmployeeUser, Long> {
    EmployeeUser findByUsername(String username);
}
