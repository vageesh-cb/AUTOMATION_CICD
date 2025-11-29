package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class OrderConfirmationPage extends AbstractComponent {

	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}

	@FindBy(css="h1[class='hero-primary']")
	WebElement confirmationMSG;
	
	public String getConfirmationMSG() {
		
		waitForTheElement(confirmationMSG);
		String conMSG=confirmationMSG.getText();
		return conMSG;
	}
}





