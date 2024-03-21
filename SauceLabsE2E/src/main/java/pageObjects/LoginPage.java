package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.ReusableComponents;

public class LoginPage extends ReusableComponents{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		
	/* Here we can follow 2 approaches  
	 *      1. Page Object Elements (WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
     *	    2. Page Factory  */
			
			@FindBy (xpath="//input[@id='user-name']")
			WebElement userName;
			
			@FindBy (xpath="//input[@id='password']")
			WebElement userPassword;
			
			@FindBy(xpath="//input[@id='login-button']")
			WebElement loginButton;
			
			@FindBy(xpath="//h3[@data-test='error']")
			WebElement errorLogin;
			
			public void goTo() {
				driver.get("https://www.saucedemo.com/");
			}
			
			public void loginApplication(String email, String password) {
				userName.sendKeys(email);
				userPassword.sendKeys(password);
				loginButton.click();
			}
			
			public String errorMessage() {
				return errorLogin.getText();
			}
			
}
