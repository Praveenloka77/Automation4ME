package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.ReusableComponents;

public class CompletionPage extends ReusableComponents{

WebDriver driver;
	
	public CompletionPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	WebElement confirmationMessage;
	
	@FindBy(xpath="//button[@id='back-to-products']")
	public WebElement backtoProductsButton;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement hamburgerMenu;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logOutButton;
	
	By msg= By.xpath("//h2[text()='Thank you for your order!']");
	
	public void logout() {
		//confirmationMessage(msg);
		//backtoProductsButton.click();
		hamburgerMenu.click();
		logOutButton.click();
	}
	
	
	
}
