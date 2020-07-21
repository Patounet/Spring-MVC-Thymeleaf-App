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
public class MvcApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(MvcApp1Application.class, args);
	}


}
