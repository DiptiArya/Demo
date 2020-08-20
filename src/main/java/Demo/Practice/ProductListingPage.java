package Demo.Practice;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProductListingPage {

	@FindBy(xpath ="//div[@class= 'column main']/div[2]/following-sibling::div[2]/div[3]/div/select/option[1] ")
	WebElement products;
	
	int c;
	
	String count;
	public WebDriver driver;

	// Constructor
	public ProductListingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ProductCount() {

		List<WebElement> PList = driver.findElements(By.xpath("//img[@class='product-image-photo']"));
		c = PList.size();
		
		count=Integer.toString(c);
		
		System.out.println("count is "+c);

	}

	public void Itemsperpage() {
		
		String Itemperpage=products.getText();
		String IT=Itemperpage.trim();
		
		System.out.println("prod count is"+IT);
		
	//	int item=Integer.parseInt(Itemperpage);
		
	
		
		if(count.equals(IT)) {	
			
			System.out.println("count of products on PLP " +IT);
		}
	}

}
