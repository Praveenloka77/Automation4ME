package Automation4ME.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class BaseTest {
	
	protected WebDriver driver;
	public LoginPage loginpage;


	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		//String browsername=prop.getProperty("browser");
		
		String browsername=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if(browsername.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
		}
		else {
            System.out.println("Invalid browser name provided.");
        }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();	
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException {
		driver=initializeDriver();
		 loginpage=new LoginPage(driver);
		loginpage.goTo();
		return loginpage;
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.close();
	}
	public WebDriver getDriver() {
        return this.driver;
    }
	
	 public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	    	
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File source=ts.getScreenshotAs(OutputType.FILE);
	    	File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	    	FileUtils.copyFile(source, file); 
	    	return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	    }
	 	
}
