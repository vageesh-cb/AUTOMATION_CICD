package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalogPage extends AbstractComponent{
	
	WebDriver driver;
	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By prd=By.cssSelector(".col-lg-4");
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	@FindBy(id="toast-container")
	WebElement toastMessage;
	
	@FindBy(css=".ng-animating")
	WebElement animationPage;
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	
	public List<WebElement> getProducts() {
		
		waitForTheElementByLocator(prd);
		return products;
		
	}
	

   public void addToCart(List<WebElement> products,String productName) {
	WebElement prd=getProductByName(products,productName);
	prd.findElement(By.cssSelector(".card-body button:last-of-type")).click();
}
   public CartPage clickCart() {
	   
	   waitForTheElement(toastMessage);
	   waitForInvisibiltyOfElement(animationPage);
	   cart.click();
	  return  new CartPage(driver);
	   
   }
	 
}
