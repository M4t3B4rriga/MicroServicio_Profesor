package com.profesor.microProfesor;

import org.springframework.boot.SpringApplication;

public class TestMicroProfesorApplication {

	public static void main(String[] args) {
		SpringApplication.from(MicroProfesorApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
