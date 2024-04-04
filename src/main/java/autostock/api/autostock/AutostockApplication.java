package autostock.api.autostock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutostockApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutostockApplication.class, args);
		System.out.println("Olá,Mundo");
	}

}
