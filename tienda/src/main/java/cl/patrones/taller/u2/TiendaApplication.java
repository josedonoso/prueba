package cl.patrones.taller.u2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = "cl.patrones.taller.u2")
@EntityScan(basePackages = "cl.patrones.taller.u2")
public class TiendaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}
	
}
