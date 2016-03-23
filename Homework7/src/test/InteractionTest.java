package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.SpringConfig;
import services.InfInteractionServ;

public class InteractionTest {

	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		InfInteractionServ interServ = context.getBean(InfInteractionServ.class);
		fail("Not yet implemented");
	}


}
