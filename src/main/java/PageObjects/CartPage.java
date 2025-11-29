package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutBTN;
	
	
	
	public Boolean verifyMatch(String productname) {
	
		Boolean flg=cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productname));
		return flg;
		
	}
	
	public CheckOutPage clickCheckout() {
		checkoutBTN.click();
		return  new CheckOutPage(driver);
	}

}


