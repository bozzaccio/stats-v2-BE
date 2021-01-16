package stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
		"stats.components",
		"stats.controllers",
		"stats.dto",
		"stats.entities",
		"stats.repositories",
		"stats.services"})
public class StatsV2Application {

	public static void main(String[] args) {
		SpringApplication.run(StatsV2Application.class, args);
	}

}