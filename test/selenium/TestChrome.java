package selenium;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import selenium.configuration.Configuration;

public class TestChrome extends EseoTest {
	
	//Attributs
	
	private static final String SYSTEM_PROPERTY = Configuration.getString("chrome_driver");
	private static final String DRIVER_LOCATION = Configuration.getString("chrome_path");

	@BeforeClass
	public static void setup() {
		EseoTest.verifyDriverLocation(DRIVER_LOCATION);				//Vérifie qu'il y a un driver
		System.setProperty(SYSTEM_PROPERTY, DRIVER_LOCATION);		//Charge le driver
		ChromeOptions options = new ChromeOptions();			
		EseoTest.driver = new ChromeDriver(options);
		EseoTest.setup();											//Insère un timeout et règle la taille de l'écra,
	}
	
	/**
	 * Test pour ouvrir la page WEB
	 */
	@Test
	public void test() {
		openWebPage();
		cliqueVersPageConnexion();
		remplisIdentifiant();
	}

}
