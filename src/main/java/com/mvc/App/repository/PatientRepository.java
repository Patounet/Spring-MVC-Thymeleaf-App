package com.mvc.App.repository;

import com.mvc.App.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAll();

    @Query("SELECT p FROM Patient p WHERE CONCAT(p.firstName, ' ', p.lastName, ' ', p.email, ' ', p.test) LIKE %?1%")
    List<Patient> search(String keyword);
}
