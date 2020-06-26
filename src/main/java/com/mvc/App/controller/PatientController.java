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

@Controller
public class PatientController {

        @Autowired
        PatientRepository repository;

        @GetMapping("/")
        public String patientsList(Model model) {
        model.addAttribute("patients", repository.findAll());
        return "patient-list";
         }

        @GetMapping("/patient/{id}")
        public String patient(@PathVariable Long id, Model model) {
            model.addAttribute("patient", repository.findById(id));
            return "patient";
        }

        @GetMapping("/create")
        public String CreateForm(Model model) {
        PatientCreation patientsForm = new PatientCreation();
        for (int i = 1; i <= 3; i++) {
            patientsForm.addPatient(new Patient());
        }

        model.addAttribute("form", patientsForm);
        model.addAttribute("patients", repository.findAll());
        return "create-patient-form";
    }


        @PostMapping("/save")
        public String saveBooks(@ModelAttribute PatientCreation form, Model model) {
        repository.saveAll(form.getPatients());

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
        model.addAttribute("patients", repository.findAll());

        return "editPatientForm";
    }

    }


