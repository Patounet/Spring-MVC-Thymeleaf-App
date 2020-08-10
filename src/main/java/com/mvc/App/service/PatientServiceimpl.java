package com.mvc.App.service;

import com.mvc.App.entity.Patient;
import com.mvc.App.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceimpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> findAll(String keyword){
        if (keyword != null){
            return patientRepository.search(keyword);
        }
        return patientRepository.findAll();
    }

    public Patient save(Patient p) {
        return patientRepository.save(p);
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }


    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
