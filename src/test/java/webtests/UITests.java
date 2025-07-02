package webtests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.HomePage;
import pages.LoginPage;

/**
 * @author Suma Kondapaneni
 * @created 01 Jul 2025
 */


public class UITests extends TestBase {

	private static final Logger logger = LogManager.getLogger(UITests.class);


    @Test(priority = 1)
    @Description("Login with valid credentials and verify user lands on home page")
    @Severity(SeverityLevel.BLOCKER)
    @Story("User Authentication")
    public void loginWithValidCredentials() { 
        logger.info("Test started: loginWithValidCredentials");
        LoginPage loginPage = new LoginPage(getDriver());

        HomePage home = loginPage.login("standard_user", "secret_sauce");
        assertTrue(home.isLeftMenuVisible(), "Home Page displayed - User successfully logged In");
    }

    @Test(priority = 2, dependsOnMethods = "loginWithValidCredentials")
    @Description("Add an item to the cart after login")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Cart Operations")
    public void addItemToCart() { 
        // TODO: implement adding item to cart
    }

    @Test(priority = 3, dependsOnMethods = "addItemToCart")
    @Description("Proceed to checkout after adding items to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Checkout Process")
    public void proceedToCheckout() { 
        // TODO: implement checkout process
    }

    @Test(priority = 4, dependsOnMethods = "loginWithValidCredentials")
    @Description("Logout from the application after successful login")
    @Severity(SeverityLevel.NORMAL)
    @Story("User Authentication")
    public void logoutFromApp() { 
        // TODO: implement logout functionality
    }

    @Test(priority = 5)
    @Description("Attempt login with invalid credentials and verify error message")
    @Severity(SeverityLevel.NORMAL)
    @Story("Negative Login Test")
    public void loginWithInvalidCredentials() {
        logger.info("Test started: loginWithInvalidCredentials");
        LoginPage loginPage = new LoginPage(getDriver());
        String error = loginPage.loginInvalid("invalid_user", "invalid_pass");
        assertTrue(error.contains("Username and password do not match any user in this service"), 
            "Error Text matches expected message");
    }

	


}
