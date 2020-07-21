package com.mvc.App.controller;
import com.mvc.App.entity.Patient;
import com.mvc.App.service.PatientServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

        @Autowired
        PatientServiceimpl patientService;

        @GetMapping("/")
        public String patientsList(Model model) {
        model.addAttribute("patients", patientService.findAll());
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


