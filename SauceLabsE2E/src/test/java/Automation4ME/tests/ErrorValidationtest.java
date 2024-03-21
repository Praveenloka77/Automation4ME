package Automation4ME.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.UIManager.LookAndFeelInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation4ME.TestComponents.BaseTest;
import Automation4ME.TestComponents.Retry;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.CompletionPage;
import pageObjects.InventoryPage;
import pageObjects.LoginPage; 


public class ErrorValidationtest extends BaseTest{
	@Test(dataProvider = "getData1", retryAnalyzer = Retry.class)
	public void Errors(HashMap<String, String>input) throws IOException, InterruptedException{

		loginpage.loginApplication(input.get("email"),input.get("password"));
		
		//Inventory page
		InventoryPage inventoryPage =new InventoryPage(driver);		
		inventoryPage.clickOnProduct("aSauce Labs Backpack");
		Assert.assertFalse(true);
	         
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
