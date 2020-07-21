package com.mvc.App.config;

import com.mvc.App.entity.Patient;
import com.mvc.App.entity.Tested;
import com.mvc.App.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfig implements CommandLineRunner {

    @Autowired
    PatientRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
        repository.save(new Patient(1, "elena", "prisca", "eprisca@gmail.com", Tested.POSITIVE));
        repository.save(new Patient(2, "Alba", "villa", "ville@gmail.com", Tested.NEGATIVE));
        repository.save(new Patient(3, "John", "Roger", "john@gmail.com", Tested.NOT_TESTED));
        repository.findAll();

    }
}
