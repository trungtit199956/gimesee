package enigma.global.gimesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class GimesiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GimesiApplication.class, args);

		System.out.println("Success!");
		
	}

}
