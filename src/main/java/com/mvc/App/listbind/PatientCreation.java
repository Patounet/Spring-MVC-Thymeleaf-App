package com.mvc.App.listbind;

import com.mvc.App.entity.Patient;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientCreation {

    private List<Patient> patients;

    public void addPatient(Patient patient) {

        try{
            this.patients.add(patient);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}