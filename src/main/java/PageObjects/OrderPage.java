package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderBTN;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover ng-star-inserted']//tbody//tr/td[2]")
	List<WebElement> orderHistory;
	
	
	
	public Boolean verifyOrderMatch(String productname) throws InterruptedException {
		orderBTN.click();
		Thread.sleep(5000);
		Boolean flg=orderHistory.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productname));
		return flg;
		
	}
	
	

}


