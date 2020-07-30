package com.mvc.App.unit;
import com.mvc.App.controller.PatientController;
import com.mvc.App.entity.Patient;
import com.mvc.App.entity.Tested;
import com.mvc.App.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(controllers = PatientController.class)
@ActiveProfiles("test")
public class PatientControllerUnitTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService service;

    private List<Patient> patientList;

    @BeforeEach
    void setUp(){
        this.patientList = new ArrayList<>();
        this.patientList.add(new Patient(1L, "carl", "roger", "ca@gmail.com", Tested.POSITIVE));
        this.patientList.add(new Patient(2L, "Hem", "lot", "ville@gmail.com", Tested.NEGATIVE));
        this.patientList.add(new Patient(3L, "trud", "ants", "john@gmail.com", Tested.NOT_TESTED));
    }


    @Test
    void shouldFetchAllPatients() throws Exception {

       when(service.findAll()).thenReturn(patientList);

       this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient-list"))
                .andExpect(model().attribute("patients", hasSize(3)));
    }

    @Test
    void shouldFetchOnePatientById() throws Exception {
        final long pId = 54l;
        final Patient patient54 = new Patient(54l, "Jean", "Gaston", "jg@gaston.com", Tested.NOT_TESTED);

        when(service.findById(pId)).thenReturn(Optional.of(patient54));

        this.mockMvc.perform(get("/edit/{id}", pId))
                .andExpect(status().isOk())
                .andExpect(view().name("create-patient-form"))
                .andExpect(model().attribute("form", hasProperty("firstName", is(patient54.getFirstName()))))
                .andExpect(model().attribute("form", hasProperty("lastName", is(patient54.getLastName()))))
                .andExpect(model().attribute("form", hasProperty("email", is(patient54.getEmail()))))
                .andExpect(model().attribute("form", hasProperty("test", is(patient54.getTest()))));
    }

    @Test
    void shouldReturnCreateForm() throws Exception{

        this.mockMvc.perform(get("/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("create-patient-form"));
    }


    @Test
    void shouldSaveNewPatientAndRedirectList() throws Exception{

        Patient patient54 = new Patient();
        patient54.setId(54l);

        when(service.save(any(Patient.class))).thenReturn(patient54);

        this.mockMvc.perform(post("/save", 54l)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("firstName", "Georges")
                    .param("lastName", "Gaston")
                    .param("email", "jg@gaston.com")
                    .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(content().string(""))
                .andExpect(redirectedUrl("/"))
                .andExpect(view().name("redirect:/"));

    }

    @Test
    public void testDeleteAction() throws Exception {

        this.mockMvc.perform(get("/delete/{id}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(service, times(1)).deleteById(anyLong());
    }
}



