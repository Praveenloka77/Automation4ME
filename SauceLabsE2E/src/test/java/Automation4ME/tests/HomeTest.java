package Automation4ME.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation4ME.TestComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.CompletionPage;
import pageObjects.InventoryPage;
import pageObjects.LoginPage; 


public class HomeTest extends BaseTest{
	
    @Test(dataProvider = "getData1")
	public void E2E(HashMap<String, String>input) throws IOException, InterruptedException{

		loginpage.loginApplication(input.get("email"),input.get("password"));
		
		//Inventory page
		InventoryPage inventoryPage =new InventoryPage(driver);		
		inventoryPage.clickOnProduct("Sauce Labs Backpack");
	
		
		//Cart Page
		CartPage cartPage=new CartPage(driver);
		cartPage.goToCart();
		cartPage.proceedToCheckout();
		//driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		
		//CheckOut Page		
		CheckoutPage checkoutpage=new CheckoutPage(driver);		
		checkoutpage.checkoutInfo("prav", "KKR", "M1P 1Y8");

         
	}
    
    @Test()
    public void closingApplication() {
    	//CompletionPage
    	loginpage.loginApplication("standard_user", "secret_sauce");
    			CompletionPage completionpage=new CompletionPage(driver);
    		//	completionpage.backtoProductsButton.click();
    	        completionpage.logout();
    }
    
    @DataProvider
    public Object[][] getData() {
    	return new Object[][] {{"standard_user", "secret_sauce"},{"error_user","secret_sauce"}};
    }
    
    @DataProvider
    public Object[][] getData1() {
    	
    	HashMap<String, String>map1=new HashMap<String, String>();
    	map1.put("email","standard_user");
    	map1.put("password","secret_sauce");
    	
    	HashMap<String, String>map2=new HashMap<String, String>();
    	map2.put("email","standard_user");
    	map2.put("password","secret_sauce");

    	return new Object[][] {{map1},{map2}};
    }
    
   
    
    
}
