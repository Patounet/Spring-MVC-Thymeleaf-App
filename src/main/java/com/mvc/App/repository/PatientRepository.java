package com.mvc.App.repository;

import com.mvc.App.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository <Patient, Long> {

    List<Patient> findByInfected(boolean positive);

    List<Patient> findAll();
}
