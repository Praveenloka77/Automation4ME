package Automation4ME.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.LoginPage;

public class ExtentReportsDemo {
	
	ExtentSparkReporter reporter;
	ExtentReports extent;	
	@BeforeTest
	public void config() {
		
		String path= System.getProperty("user.dir")+"\\reports\\index1.html";
		reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Praveen");
	}
	
	@Test
	public void Demo() throws InterruptedException {
		
		ExtentTest test=extent.createTest("Demo 1");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		//Home page
		driver.get("https://www.saucedemo.com/");		
		//Login Page
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Thread.sleep(3000);
		driver.close();
		
		extent.flush();
	}
}
