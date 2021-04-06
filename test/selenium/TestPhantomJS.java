package selenium;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import selenium.configuration.Configuration;

public class TestPhantomJS extends EseoTest {
	
	private static final String SYSTEM_PROPERTY = Configuration.getString("phantomjs_driver");
	
	private static final String DRIVER_LOCATION = Configuration.getString("phantomjs_path");
	
	@BeforeClass
	public static void setup() {
		EseoTest.verifyDriverLocation(DRIVER_LOCATION);
		System.setProperty(SYSTEM_PROPERTY,DRIVER_LOCATION);
		EseoTest.driver = new PhantomJSDriver();
		EseoTest.setup();		
	}
	
	@Test
	public void testOpenWebPagePhantomJS() {
		openWebPage();
	}
}