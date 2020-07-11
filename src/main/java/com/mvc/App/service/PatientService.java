package com.mvc.App.service;

import com.mvc.App.entity.Patient;
import com.mvc.App.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public void savePatients(Patient p) {
        patientRepository.save(p);
    }
}
