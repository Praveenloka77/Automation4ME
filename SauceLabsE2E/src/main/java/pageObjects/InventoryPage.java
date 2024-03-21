package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	List<WebElement> products;
	
	public void clickOnProduct(String productName) {
		for(WebElement product : products) {
			if(product.getText().equals(productName)) {
				product.click();
				break;
			}
		}
	}
	

}
