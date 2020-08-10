package com.mvc.App.controller;
import com.mvc.App.entity.Patient;
import com.mvc.App.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

        @Autowired
        PatientService patientService;

        @GetMapping("/")
        public String patientsList(Model model, @Param("keyword") String keyword) {
        List<Patient> listPatients = patientService.findAll(keyword);
        model.addAttribute("patients", listPatients);
        model.addAttribute("keyword", keyword);
        return "patient-list";
        }

        @GetMapping("/create")
        public String createForm(Model model) {
        model.addAttribute("form", new Patient());
        return "create-patient-form";
        }

        @PostMapping("/save")
        public String savePatients(Patient patient, Model model) {
        patientService.save(patient);
        return "redirect:/";
        }

        @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("form", patientService.findById(id).orElse(new Patient()));
        return "create-patient-form";
        }

        @GetMapping("/delete/{id}")
        public String deletePatient(@PathVariable  Long id) {
        patientService.deleteById(id);
        return "redirect:/";
        }
  }


