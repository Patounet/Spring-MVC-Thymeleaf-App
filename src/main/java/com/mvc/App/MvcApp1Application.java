package com.mvc.App;

import com.mvc.App.entity.Patient;
import com.mvc.App.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MvcApp1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MvcApp1Application.class, args);
	}

	@Autowired
	PatientRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		repository.save(new Patient(1, "elena", "prisca", "eprisca@gmail.com", false));
		repository.save(new Patient(2, "Alba", "villa", "ville@gmail.com", false));
		repository.save(new Patient(3, "John", "Roger", "john@gmail.com", true));
		repository.findAll();

	}
}
