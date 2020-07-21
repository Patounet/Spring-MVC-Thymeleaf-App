package com.mvc.App.service;

import com.mvc.App.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface serviceInterface {


        Optional<Patient> findById(Long id);
        List<Patient> findAll();
        Patient save(Patient patient);
        void deleteById(Long id);

}
