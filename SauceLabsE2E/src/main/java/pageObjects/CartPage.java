package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.ReusableComponents;

public class CartPage extends ReusableComponents{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By findby=By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") 
	WebElement productClickButton;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement cartIcon;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkOutButton;
	
	  public void goToCart() {
		  waitForElementToAppear(findby);
		  productClickButton.click();
	        cartIcon.click();
	    }

	    public void proceedToCheckout() {
	    	checkOutButton.click();
	    }
	

}
