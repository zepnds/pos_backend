package com.zepnds.pos_system;

import com.zepnds.pos_system.auth.AuthRegisterRequest;
import com.zepnds.pos_system.auth.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static com.zepnds.pos_system.user.Role.ADMIN;
import static com.zepnds.pos_system.user.Role.MANAGER;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PosSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosSystemApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = AuthRegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("sojda018@gmail.com")
					.password("COREjoseph@018")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = AuthRegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}
}
