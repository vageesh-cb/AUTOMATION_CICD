package AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;

	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}


	public void waitForTheElementByLocator(By findby) {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(findby)));
         
	}
	
	public WebElement getProductByName(List<WebElement> products,String productName) {
		
		 WebElement product=products.stream().filter(s->s.findElement(By.cssSelector(" h5 b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		 return product;
		
	}
	

	public void waitForTheElement(WebElement element) {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(element));
         
	}
	
	public void waitForInvisibiltyOfElement(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	
}
