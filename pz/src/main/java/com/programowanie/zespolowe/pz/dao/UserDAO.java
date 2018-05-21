package com.programowanie.zespolowe.pz.dao;

import com.programowanie.zespolowe.pz.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User,Long> {

}
