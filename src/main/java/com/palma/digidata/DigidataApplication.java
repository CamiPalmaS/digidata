package com.palma.digidata;

import com.palma.digidata.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigidataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DigidataApplication.class, args);
	}


	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.showMenu();
	}
}
