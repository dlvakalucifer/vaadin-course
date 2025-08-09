package dev.vaadin.udemy_course;

import org.springframework.boot.SpringApplication;

public class TestUdemyCourseApplication {

	public static void main(String[] args) {
		SpringApplication.from(UdemyCourseApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
