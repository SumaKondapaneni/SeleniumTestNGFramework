package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;
/**
 * @author Suma Kondapaneni
 * @created 01 Jul 2025
 */


public class HomePage extends PageBase {
	@FindBy(xpath = "//*[@id='react-burger-menu-btn']")
	WebElement leftMenu;

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isLeftMenuVisible() {

		return leftMenu.isDisplayed();
	}
	
	
   

}
