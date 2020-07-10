package com.mvc.App.controller;

import com.mvc.App.entity.Patient;
import com.mvc.App.listbind.PatientCreation;
import com.mvc.App.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class PatientController {

        @Autowired
        PatientRepository repository;

        @GetMapping("/")
        public String patientsList(Model model) {
        model.addAttribute("patients", repository.findAll());
        return "patient-list";
         }

        @GetMapping("/create")
        public String CreateForm(Model model) {
        PatientCreation patientsForm = new PatientCreation();
        for (int i = 1; i <= 5; i++) {
            patientsForm.addPatient(new Patient());
        }
        model.addAttribute("form", patientsForm);
        return "create-patient-form";
        }

        @PostMapping("/save")
        public String savePatients(@ModelAttribute PatientCreation form,  Model model) {
            List<Patient> filteredPatients = form.getPatient()
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> !p.getTest().getDisplayValue().isBlank())
                .collect(Collectors.toList());

        for (Patient p : filteredPatients){
                repository.save(p);
        }


        model.addAttribute("patients", repository.findAll());
        return "redirect:/";
        }

        @GetMapping(value = "/edit")
         public String showEditForm(Model model) {
        List<Patient> patients = new ArrayList<>();
        repository.findAll()
                .iterator()
                .forEachRemaining(patients::add);

       model.addAttribute("form", new PatientCreation(patients));
       return "editPatientForm";
       }
  }


