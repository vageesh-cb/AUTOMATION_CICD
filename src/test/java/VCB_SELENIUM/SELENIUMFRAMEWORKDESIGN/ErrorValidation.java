package VCB_SELENIUM.SELENIUMFRAMEWORKDESIGN;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.LoginPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.ProductCatalogPage;
import TestComponents.BaseClass;

public class ErrorValidation extends BaseClass {

	@Test(groups= {"Error"},retryAnalyzer=TestComponents.Retry.class)
	public void loginErrorValidation() throws IOException {

		loginpage.loginApplication("vcb91@gmail.com", "Test@1234");
		Assert.assertTrue(loginpage.errorMSGCheck().equalsIgnoreCase("Incorrect email or password."));

	}

	@Test

	public void productErrorValidation() {

		String productName = "ADIDAS ORIGINAL";
		ProductCatalogPage productcatlog = loginpage.loginApplication("vcb91@gmail.com", "Test@123");
		List<WebElement> products = productcatlog.getProducts();
		productcatlog.addToCart(products, productName);
		productcatlog.clickCart();
		CartPage cart = new CartPage(driver);
		boolean flag = cart.verifyMatch("ZARA");
		Assert.assertTrue(flag);
	}

}
