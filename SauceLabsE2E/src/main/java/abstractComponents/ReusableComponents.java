package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {
	
	WebDriver driver;
	 WebDriverWait wait;
	
	public ReusableComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	public void waitForElementToAppear(By findby) {
		  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(findby));
	    
	}
	
	public void confirmationMessage(By confirm) {
		 WebElement thankYouMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
	        String message = thankYouMessage.getText();
	        System.out.println(message);
	}

}
	