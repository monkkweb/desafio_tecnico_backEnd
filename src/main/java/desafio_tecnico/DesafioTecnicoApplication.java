package desafio_tecnico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackages = "desafio_tecnico.repositorio")
@EnableScheduling
public class DesafioTecnicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTecnicoApplication.class, args);
	}
}