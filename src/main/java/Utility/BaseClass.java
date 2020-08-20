package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

public WebDriver driver;
	
	
	public WebDriver Intitializebrowser() throws IOException {
		
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Object1.Properties");
		
		prop.load(fis);
		
		String Browsername=prop.getProperty("Browser");
		String URL=prop.getProperty("siteURL");
		if(Browsername.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			
			driver= new ChromeDriver();
		}
			
			else if(Browsername.equals("Firefox"))	{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
				
				driver= new FirefoxDriver();
			}
		
			else if(Browsername.equals("InternetExplorer"))
			{
				
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\IEDriverServer.exe");
				
				WebDriver driver= new InternetExplorerDriver();
				
			}
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
			
			driver.get(URL);
			
			return driver;
		}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}

