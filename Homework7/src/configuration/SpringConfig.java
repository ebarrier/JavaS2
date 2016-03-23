package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import services.InfInteractionServ;
import services.InteractionScanner;
import services.InteractionTextIO;

@Configuration
@Profile("production")
public class SpringConfig {
	
	@Bean
	@Primary
	public InfInteractionServ getTextIOServ() {
		return new InteractionTextIO();
	}
	
	@Bean
	public InfInteractionServ getScannerServ() {
		return new InteractionScanner();
	}

}
