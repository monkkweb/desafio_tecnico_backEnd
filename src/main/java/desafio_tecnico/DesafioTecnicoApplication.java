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

    //TODO: Criar dtos das entidades Ok
    //TODO: Melhoria de calculo
    //TODO: Melhoria nos testes
    //TODO: Criar regras nova -> fazer calculo para a data de registro e analaisar se tera mudança de pontuação para
    // os dependentes de cada familia e recalcular os dependentes
    // criar um login de verdade por email

    // TODO: [Melhoria] Estudar MapStruct para substituir Mappers manuais e reduzir código repetitivo.
    // TODO: [Melhoria] Implementar tratamento de exceções global (@ControllerAdvice) para erros 404/400 mais amigáveis.
    // TODO: [Melhoria] Adicionar validações (@NotNull, @Min, @Size) nos DTOs com Bean Validation.
    // TODO: [Melhoria] Refatorar "Magic Numbers" (900, 1500) nas calculadoras para constantes ou application.properties.

	public static void main(String[] args) {
		SpringApplication.run(DesafioTecnicoApplication.class, args);
	}
}
