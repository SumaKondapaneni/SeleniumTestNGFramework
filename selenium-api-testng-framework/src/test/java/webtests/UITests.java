package webtests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

/**
 * @author Suma Kondapaneni
 * @created 01 Jul 2025
 */


public class UITests extends TestBase {

	private static final Logger logger = LogManager.getLogger(UITests.class);


	@Test(priority = 1) // Highest business value
	public void loginWithValidCredentials() { 
		logger.info("Test started: testLoginFunctionality");
		LoginPage loginPage = new LoginPage(getDriver());
		
	     
		HomePage home = loginPage.login("standard_user", "secret_sauce");
		assertTrue(home.isLeftMenuVisible(), "Home Page displayed - User successfully logged In");
		
		
		
		
	}

	@Test(priority = 2, dependsOnMethods = "loginWithValidCredentials")
	public void addItemToCart() { 
	
		
		
	}

	@Test(priority = 3, dependsOnMethods = "addItemToCart")
	public void proceedToCheckout() { 
		
	}

	@Test(priority = 4, dependsOnMethods = "loginWithValidCredentials")
	public void logoutFromApp() { 
		
	}

	@Test(priority = 5)
	public void loginWithInvalidCredentials() {
		
		logger.info("Test started: testLoginFunctionality");
		LoginPage loginPage = new LoginPage(getDriver());
		String error =loginPage.loginInvalid("inavlid_user", "invalid_pass");
        assertTrue(error.contains("Username and password do not match any user in this service"), "Error Text matches with the expected - Username and password do not match any user in this service");
	}
	
	


}
