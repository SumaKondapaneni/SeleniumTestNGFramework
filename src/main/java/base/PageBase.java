package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



/**
 * @author Suma Kondapaneni
 * @created 01 Jul 2025
 */



public class PageBase {

	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
