package dev.vaadin.udemy_course;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UdemyCourseApplication implements AppShellConfigurator
{

	public static void main(String[] args) {
		SpringApplication.run(UdemyCourseApplication.class, args);
	}

}
