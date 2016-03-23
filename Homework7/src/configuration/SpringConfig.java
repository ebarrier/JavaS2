package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import services.InfInteractionServ;
import services.InteractionService;

@Configuration
public class SpringConfig {
	
	@Bean
	public InfInteractionServ getInteractionService() {
		return new InteractionService();
	}

}
