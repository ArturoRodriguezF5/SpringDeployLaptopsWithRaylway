package com.arthycode.RestAPILaptops;

import com.arthycode.RestAPILaptops.entity.Laptop;
import com.arthycode.RestAPILaptops.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestApiLaptosApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(RestApiLaptosApplication.class, args);
		LaptopRepository repo = context.getBean(LaptopRepository.class);

		repo.save(new Laptop(null, "Dell", "D162", false));
		repo.save(new Laptop(null, "Acer", "A1534", false));
		repo.save(new Laptop(null, "Mac", "Mdd2", true));
	}

}
