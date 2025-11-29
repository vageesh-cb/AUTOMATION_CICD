package VCB_SELENIUM.SELENIUMFRAMEWORKDESIGN;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.LoginPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.OrderPage;
import PageObjects.ProductCatalogPage;
import TestComponents.BaseClass;

public class StandaloneETETEST extends BaseClass {

	
	@Test
	public void submitOrder() throws IOException {
		
		String productName = "ADIDAS ORIGINAL";
		String country = "India";
		String confirmationMESSAGE = "THANKYOU FOR THE ORDER.";

		
		
	    ProductCatalogPage productcatlog = loginpage.loginApplication("vcb91@gmail.com", "Test@123");
		List<WebElement> products = productcatlog.getProducts();
		productcatlog.addToCart(products, productName);
		CartPage cart=productcatlog.clickCart();
		boolean flag = cart.verifyMatch(productName);
		Assert.assertTrue(flag);
		CheckOutPage checkout = cart.clickCheckout();
		checkout.entryCountry(country);
		checkout.selectCountry(country);
		OrderConfirmationPage order =checkout.placeOrder();
		Assert.assertTrue(order.getConfirmationMSG().equalsIgnoreCase(confirmationMESSAGE));
		

	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	
	public void verifyOrderSubmitted() throws InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		loginpage.loginApplication("vcb91@gmail.com", "Test@123");
		OrderPage orderpage=new OrderPage(driver);
		boolean flag=orderpage.verifyOrderMatch(productName);
		Assert.assertTrue(flag);
		
		
	}

	

}
