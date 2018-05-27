package com.programowanie.zespolowe.pz.dao;

import com.programowanie.zespolowe.pz.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDAO extends JpaRepository<Group,Integer> {

}
