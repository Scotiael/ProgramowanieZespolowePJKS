package com.programowanie.zespolowe.pz.dao;

import com.programowanie.zespolowe.pz.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends CrudRepository<Role,Integer> {

}
