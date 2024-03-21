package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement fName;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement lName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement finishButton;
	
	public void checkoutInfo(String firstname, String lastname,String postal) {
		fName.sendKeys(firstname);
		lName.sendKeys(lastname);
		postalCode.sendKeys(postal);
		continueButton.click();
		finishButton.click();
		
	}
}
