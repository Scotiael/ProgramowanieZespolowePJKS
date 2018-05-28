package com.programowanie.zespolowe.pz.dao;

import com.programowanie.zespolowe.pz.entities.Devicefamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceFamilyDAO extends JpaRepository<Devicefamily,Integer> {

}
