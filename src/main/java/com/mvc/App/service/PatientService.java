package com.mvc.App.service;

import com.mvc.App.entity.Patient;
import com.mvc.App.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public void savePatient(Patient p) {
        patientRepository.save(p);
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
