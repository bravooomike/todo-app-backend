package pl.bravooomike.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class TodoApplication {

//	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(TodoApplication.class);
//		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
//		app.run(args);
//	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
