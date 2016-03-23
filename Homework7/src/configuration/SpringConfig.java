package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import services.InfInteractionServ;
import services.InteractionScanner;
import services.InteractionTextIO;

@Configuration
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
