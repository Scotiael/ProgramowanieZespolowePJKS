package com.programowanie.zespolowe.pz.dao;

import com.programowanie.zespolowe.pz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {

    @Query
    User findByEmail(String email);

}
