package com.zepnds.pos_system;

import com.zepnds.pos_system.auth.AuthenticationService;
import com.zepnds.pos_system.auth.RegisterRequest;
import com.zepnds.pos_system.products.Category;
import com.zepnds.pos_system.products.CategoryRepository;
import com.zepnds.pos_system.products.Supplier;
import com.zepnds.pos_system.products.SupplierRepository;
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
		CategoryRepository categoryRepository,
		SupplierRepository supplierRepository
	) {


		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("sojda018@gmail.com")
					.password("COREjoseph@018")
					.role(Role.ADMIN)
					.build();
		 	service.register(admin);

			var merchant =  RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("zepnds@gmail.com")
					.password("COREjoseph@018")
					.role(Role.MERCHANT)
					.build();
			service.register(merchant);

			Category category = new Category();
			Supplier supplier = new Supplier();

			category.setCategory_name("sample category");
			supplier.setSupplier_name("sample supplier");
			supplier.setContact_info("09615290648");
			categoryRepository.save(category);
			supplierRepository.save(supplier);
		};
	}

}

//https://github.com/dailycodebuffer/Spring-MVC-Tutorials