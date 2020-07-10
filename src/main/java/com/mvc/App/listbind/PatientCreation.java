package com.mvc.App.listbind;

import com.mvc.App.entity.Patient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class PatientCreation {


    private List<Patient> patients;

    public PatientCreation() {
        this.patients = new ArrayList<>();
    }

    public PatientCreation(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatient() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }
}
