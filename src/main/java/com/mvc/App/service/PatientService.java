package com.mvc.App.service;

import com.mvc.App.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {


        Optional<Patient> findById(Long id);

        List<Patient> findAll(String keyword);

        Patient save(Patient patient);

        void deleteById(Long id);

}
