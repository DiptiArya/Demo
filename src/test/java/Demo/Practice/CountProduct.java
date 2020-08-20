package Demo.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.BaseClass;

public class CountProduct extends BaseClass {
	
	public WebDriver driver;


	
	
	@Test
	public void getCount() throws IOException {
		
		driver = Intitializebrowser();
		ProductListingPage p = new ProductListingPage(driver);
		p.ProductCount();
		
		p.Itemsperpage();
		
	}
	
	
}
