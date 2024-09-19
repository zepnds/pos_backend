package com.zepnds.pos_system;

import com.zepnds.pos_system.auth.AuthenticationService;
import com.zepnds.pos_system.auth.RegisterRequest;
import com.zepnds.pos_system.products.CategoryRepository;
import com.zepnds.pos_system.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PosSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service,
			CategoryRepository repository
	) {


		return args -> {
			 RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("sojda018@gmail.com")
					.password("COREjoseph@018")
					.role(Role.ADMIN)
					.build();


			 RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("zepnds@gmail.com")
					.password("COREjoseph@018")
					.role(Role.MERCHANT)
					.build();


		};
	}
}

//https://github.com/dailycodebuffer/Spring-MVC-Tutorials