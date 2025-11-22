package dsa.java.code.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
// @SpringBootApplication(scanBasePackages = "dsa.java.code.playground")
public class JavaCodePlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaCodePlaygroundApplication.class, args);
	}

}


