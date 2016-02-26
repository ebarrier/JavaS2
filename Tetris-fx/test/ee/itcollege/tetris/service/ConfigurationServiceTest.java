package ee.itcollege.tetris.service;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class ConfigurationServiceTest {
	
	@Test
	public void test() throws FileNotFoundException, IOException {
		
		ConfigurationService service = new ConfigurationService();
		service.loadFile("test/test.properties");
		assertEquals("value", service.getStringValue("key"));
		assertEquals("123", service.getStringValue("numeric"));
		assertEquals("dottest", service.getStringValue("test.with.dot"));
		assertEquals("hello world", service.getStringValue("whitespace"));
		assertEquals(null, service.getStringValue("absentkey"));
	}

}