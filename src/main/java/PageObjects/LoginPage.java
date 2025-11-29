package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="#userEmail")
	WebElement userName;
	
	@FindBy(css="#userPassword")
	WebElement passWord;
	
	@FindBy(id="login")
	WebElement loginBTN;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement errorMSG;
	public ProductCatalogPage loginApplication(String username,String password) {
		
		userName.sendKeys(username);
		passWord.sendKeys(password);
		loginBTN.click();
		return new ProductCatalogPage(driver);
		
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	
	}
	
	public String errorMSGCheck() {
		
		waitForTheElement(errorMSG);
		System.out.println(errorMSG.getText());
		return errorMSG.getText();
	}
}
