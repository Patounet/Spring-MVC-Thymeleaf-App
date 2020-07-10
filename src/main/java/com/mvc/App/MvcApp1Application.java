package com.mvc.App;

import com.mvc.App.entity.Patient;
import com.mvc.App.entity.Tested;
import com.mvc.App.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
		repository.save(new Patient(1, "elena", "prisca", "eprisca@gmail.com", Tested.POSITIVE));
		repository.save(new Patient(2, "Alba", "villa", "ville@gmail.com", Tested.NEGATIVE));
		repository.save(new Patient(3, "John", "Roger", "john@gmail.com", Tested.NOT_TESTED));
		repository.findAll();

	}
}
