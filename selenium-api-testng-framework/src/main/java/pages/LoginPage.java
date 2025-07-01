package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

/**
 * @author Suma Kondapaneni
 * @created 01 Jul 2025
 */

public class LoginPage extends PageBase {

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	@FindBy(id = "user-name")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "login-button")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage login(String username, String password) {
		logger.info("Logging in with username: " + username);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		logger.info("Clicked on the Login");
		return new HomePage(driver);
	}
	
	

	public String loginInvalid(String username, String password) {
		logger.info("Logging in with username: " + username);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		logger.info("Clicked on the Login");
		String error = driver.findElement(By.xpath("//div[contains(@class,'error')]/h3")).getText();
	    return error;
		
	}
    public List<WebElement> getPageTitle() {
    	
    	List<WebElement> tags = driver.findElements(By.tagName("p"));
    	

		return tags;
        
    }
	
}
