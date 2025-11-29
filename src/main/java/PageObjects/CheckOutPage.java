package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	    PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryENT;
	
	public void entryCountry(String country) {
		countryENT.sendKeys(country);
	}
	
 @FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']//span")
 List<WebElement> countryDD;
	
@FindBy(css="a[class='btnn action__submit ng-star-inserted']")
WebElement placeOrder;
 
 public void selectCountry(String country) {
	
	 WebElement ddcountry=countryDD.stream().filter(c->c.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
	 ddcountry.click();
	 
 }
 
 
 public OrderConfirmationPage placeOrder() {
	 placeOrder.click();
	return  new OrderConfirmationPage(driver);
 }

	
}
