package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import services.InfInteractionServ;
import services.InteractionTextIO;

@Configuration
@Profile("test")
public class SpringJunitConfig {

	@Bean
	public InfInteractionServ TextIOTest1() {
		int num = 123;
		return new InteractionTextIO();
	}
	
	@Bean
	public InfInteractionServ TextIOTest2() {
		int num = 0133;
		return new InteractionTextIO();
	}
	
	@Bean
	public InfInteractionServ TextIOTest3() {
		int num = -1234;
		return new InteractionTextIO();
	}
	
	@Bean
	public InfInteractionServ TextIOTest4() {
		int num = -0534;
		return new InteractionTextIO();
	}
}
