package com.programowanie.zespolowe.pz.dao;

import com.programowanie.zespolowe.pz.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDAO extends JpaRepository<Device,Integer> {

}
