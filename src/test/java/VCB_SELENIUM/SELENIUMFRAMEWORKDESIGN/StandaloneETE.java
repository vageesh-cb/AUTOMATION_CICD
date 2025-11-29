package VCB_SELENIUM.SELENIUMFRAMEWORKDESIGN;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneETE {

	public static void main(String[] args) {
    
		WebDriver driver=new ChromeDriver();
        
		String productName="ADIDAS ORIGINAL";
		String country ="India";
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("vcb91@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 
	       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".col-lg-4"))));
           
           List<WebElement>products=driver.findElements(By.cssSelector(".col-lg-4"));
           
           WebElement product=products.stream().filter(s->s.findElement(By.cssSelector(" h5 b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
           product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
           
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		  driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		 List<WebElement> cartProducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		 Boolean flg=cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));
		 Assert.assertTrue(flg);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(country);
		
		List<WebElement> countryDD=driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//span"));
		 WebElement ddcountry=countryDD.stream().filter(c->c.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
		 ddcountry.click();
		 
		 driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']")).click();
		 WebElement confirmationMSG=driver.findElement(By.cssSelector("h1[class='hero-primary']"));
		 wait.until(ExpectedConditions.visibilityOf(confirmationMSG));
		 System.out.println(confirmationMSG.getText());
		 Assert.assertTrue(confirmationMSG.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 driver.close();

	}

}
