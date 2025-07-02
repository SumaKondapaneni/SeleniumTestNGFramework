
package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * @author Suma Kondapaneni
 * @created 01 Jul 2025
 */


public class TestBase {

	@BeforeMethod
	public void setUp() {
		DriverManager.initDriver();
	}

	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}
}