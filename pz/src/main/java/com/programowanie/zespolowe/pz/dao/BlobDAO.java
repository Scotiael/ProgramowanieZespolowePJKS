package com.programowanie.zespolowe.pz.dao;

import com.programowanie.zespolowe.pz.entities.Blob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlobDAO extends JpaRepository<Blob,Integer> {

}
