package selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import selenium.configuration.Configuration;

/**
 * The EseoTest abstract class is the parent class used by the subclasses
 * defined for each specific browser tpye. It contains the methods that are
 * shared by the different subclasses.
 */
public abstract class EseoTest {

	/**
	 * The WebDriver instance used to automate the browser.
	 */
	protected static WebDriver driver;

	/**
	 * Method that asks the WebDriver to open a webpage in the chosen web browser.
	 * 
	 * @param screenshotFilename the name of the file that will store the png image.
	 */
	protected void openWebPage() {
		EseoTest.driver.get(Configuration.getString("website_address"));
		//Assert.assertEquals("Web page title does not appear correct.", Configuration.getString("login_title"),
			//	EseoTest.driver.getTitle());		
		Assert.assertEquals("Browser title bar does not appear correct.",Configuration.getString("homepage_title"),EseoTest.driver.getTitle());
		Assert.assertEquals("Site title does not appear correct.",Configuration.getString("blog_title"),EseoTest.driver.findElement(By.tagName("h1")).getText());
		Assert.assertEquals("Site description does not appear correct.",Configuration.getString("blog_description"),EseoTest.driver.findElement(By.tagName("p")).getText());
		Assert.assertTrue("Log in item does not appear correct.",EseoTest.driver.findElement(By.linkText(Configuration.getString("mainmenu_login_item"))).isDisplayed());
	}
	
	protected void cliqueVersPageConnexion() {
		EseoTest.driver.findElement(By.linkText(Configuration.getString("mainmenu_login_item"))).click();
		Assert.assertEquals("Browser title bar does not appear correct.",Configuration.getString("login_title"),EseoTest.driver.getTitle());
		Assert.assertTrue("Username field does not appear correct.",EseoTest.driver.findElement(By.id("user_login")).isDisplayed());
		Assert.assertTrue("Password field does not appear correct.",EseoTest.driver.findElement(By.id("user_pass")).isDisplayed());
		Assert.assertEquals("Login button does not appear correct.",Configuration.getString("login_button"),EseoTest.driver.findElement(By.id("wp-submit")).getAttribute("value"));
	}
	
	protected void remplisIdentifiant() {
		EseoTest.driver.findElement(By.id("user_login")).sendKeys(Configuration.getString("username"));
		EseoTest.driver.findElement(By.id("user_pass")).sendKeys(Configuration.getString("password"));
		EseoTest.driver.findElement(By.id("wp-submit")).click();
	}
	
	
	
	
	
	
	
	
	
	

	/**
	 * The teardown method is used to quit the WebDriver, that is to say, close the
	 * web browser and free up system resources.
	 */
	//@AfterClass
	public static void teardown() {
		driver.quit();
	}

	/**
	 * Verifies that a file exists in the driverlocation.
	 * 
	 * @param driverLocation the absolute path to the webdriver file.
	 */
	public static void verifyDriverLocation(String driverLocation) {
		File driverFile = new File(driverLocation);
		if (!driverFile.exists()) {
			Assert.fail("Could not find executable: " + driverLocation);
		}
	}

	/**
	 * Setup the WebDriver instance to use certain properties. An implicit timeout
	 * of two seconds and a window size of 1024 x 768 pixels.
	 * 
	 */
	public static void setup() {
		EseoTest.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		EseoTest.driver.manage().window().setSize(new Dimension(1024, 768));
	}

}
