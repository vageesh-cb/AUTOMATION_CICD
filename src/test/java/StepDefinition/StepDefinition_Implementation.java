package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.LoginPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.ProductCatalogPage;
import TestComponents.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition_Implementation extends BaseClass {
   
	public LoginPage loginpage;
	public  ProductCatalogPage productcatlog;
	 public List<WebElement> products ;
	public  CartPage cart;
	public CheckOutPage checkout;
	public	OrderConfirmationPage order;
	
	@Given("I landed on LoginPage")
	public void I_landed_on_LoginPage() throws IOException{
		loginpage=	launchApplication();

	}
	
	@Given("^Logged in with UserName (.+) and Password (.+)$")
	public void Logged_in_with_UserName_and_Password(String username,String password) {
	 productcatlog = loginpage.loginApplication(username, password);
	}

	
	@When("^I add product (.+) to cart$")
	public void  I_add_product_to_cart(String productname) {
		 products = productcatlog.getProducts();
		
	}
	
	@When("^checkout (.+) and submit order$")
	public void checkout_and_submit(String productname)
	{
	
		productcatlog.addToCart(products, productname);
		cart=productcatlog.clickCart();
		boolean flag = cart.verifyMatch(productname);
		Assert.assertTrue(flag);
		checkout = cart.clickCheckout();
		checkout.entryCountry("India");
		checkout.selectCountry("India");
		order =checkout.placeOrder();
		
	}
	@Then("{string} message is displayed on confirmation page")
	public void verify_confirmation_message(String confirmationMESSAGE ) {
	
		Assert.assertTrue(order.getConfirmationMSG().equalsIgnoreCase(confirmationMESSAGE));
		driver.close();
	}
	@Then("{string} message is displayed")
	public void  error_message_is_displayed(String string) {
		
		Assert.assertTrue(loginpage.errorMSGCheck().equalsIgnoreCase(string));
	}
}
