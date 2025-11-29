package VCB_SELENIUM.SELENIUMFRAMEWORKDESIGN;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.ProductCatalogPage;
import TestComponents.BaseClass;

public class StandaloneETETESTParamertization extends BaseClass {

	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void purchaseOder(HashMap<String,String> input) throws IOException {
		
		String country = "India";
		String confirmationMESSAGE = "THANKYOU FOR THE ORDER.";

		
		String productName= input.get("productName");
		
	    ProductCatalogPage productcatlog = loginpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatlog.getProducts();
		productcatlog.addToCart(products, productName);
		productcatlog.clickCart();
		CartPage cart = new CartPage(driver);
		boolean flag = cart.verifyMatch(productName);
		Assert.assertTrue(flag);
		cart.clickCheckout();
		CheckOutPage checkout = new CheckOutPage(driver);
		checkout.entryCountry(country);
		checkout.selectCountry(country);
		checkout.placeOrder();
		OrderConfirmationPage order = new OrderConfirmationPage(driver);
		Assert.assertTrue(order.getConfirmationMSG().equalsIgnoreCase(confirmationMESSAGE));
		

	}
	
	

	@DataProvider
	
	public Object[][] getData() throws IOException {
		
		
		List<HashMap<String,String>> data=getJSONDatatoMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	
	}
	

}
/*HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email", "vcb91@gmail.com");
		map1.put("password", "Test@123");
		map1.put("productname", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map2=new HashMap<String,String>();
		map2.put("email", "vcbtest91@gmail.com");
		map2.put("password", "Test@123");
		map2.put("productname", "ZARA COAT 3");*/

//return	new Object[][] {{"vcb91@gmail.com","Test@123","ADIDAS ORIGINAL"},{"vcbtest91@gmail.com","Test@123","ZARA COAT 3"}};