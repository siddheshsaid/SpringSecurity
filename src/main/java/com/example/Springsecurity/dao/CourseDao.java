package com.example.Springsecurity.dao;


import com.example.Springsecurity.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseDao extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.emailId = :email")
    User getUserDetailsByUserName(@Param("email") String email);
}
