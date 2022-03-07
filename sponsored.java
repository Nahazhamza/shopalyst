package shopalyst;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;



public class sponsored {
	WebDriver driver;
	
	     
	
	
	
	@BeforeTest
	public void browserinit()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/nahazmuhammed/test/com.shopalyst.demojava/src/main/java/drivers/chromedriver");
		driver=  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void TC__001()
	{
		driver.get("https://amazon.com/");
		
	}
//	@Test(priority=1)
//	public void TC__002() throws InterruptedException
//	{
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("face cream for dry skin");
//		Thread.sleep(2000);
//		driver.findElement(By.id("nav-search-submit-button")).click();
//		Thread.sleep(2000);
//	}
//	
	
	/* reverse checking.... checking with sponsored link and then checking the associated products
	@Test(priority=2)
	public void TC__003() throws InterruptedException
	{
		List<WebElement> div_elem = driver.findElements(By.xpath("//span [@class='s-label-popover-default']/preceding::div[1]"));	
		
		for (WebElement e : div_elem)
			
	    {   
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("arguments[0].style.border='2px solid red'", e);
			Thread.sleep(300);
			String product = e.findElement(By.tagName("img")).getAttribute("alt");
			//String name= e.findElement(By.tagName("img")).getAttribute("alt");
			System.out.println(product);
			
			if(product.contains("Eucerin"))
			{	
//				Assertion sa = new SoftAssert();
//				sa.assertTrue(true);
				Assert.assertTrue(true);
			}
			
	    
	    }

//		//String Div_text = Div_elem.getText();
		//String img_text=Div_elem.findElement(By.tagName("img")).getAttribute("alt");
		//System.out.println(Div_text);
		//System.out.println(img_text);
		//List<WebElement> elements = driver.findElements(By.xpath("//span [@class='s-label-popover-default']/preceding::div[1]"));
//		String m = driver.findElement(By.xpath("//span[@class='s-label-popover-default']/preceding::div[1]")).getAttribute("alt");
//		
//		//span [@class='s-label-popover-default']/parent::a/parent::span/parent::div/preceding::h2
//		System.out.println(m);
//		//System.out.println(m.getAttribute("alt"));
		
		
		
		
	}

	
	
	*/
//	@Test(priority=3)
//	public void TC__003() throws InterruptedException
//	{
//		List<WebElement> elem = driver.findElements(By.xpath("//a/span[contains(text(),'CETAPHIL')]"));	
//		int productcount;
//		for (WebElement e : elem)
//			
//	    {   
//			JavascriptExecutor js = (JavascriptExecutor) driver;  
//			js.executeScript("arguments[0].style.border='2px solid red'", e);
//			Thread.sleep(300);
//			String product = e.findElement(By.xpath("//a/span[contains(text(),'CETAPHIL')]/ancestor::div[1]/div[1]/span")).getText();
//			//String name= e.findElement(By.tagName("img")).getAttribute("alt");
//			System.out.println(product);
//			productcount = product.length();
//			
//			
////			if(product.contains("CETAPHIL"))
////			{	
//////				Assertion sa = new SoftAssert();
//////				sa.assertTrue(true);
////				Assert.assertTrue(true);
////			}
//	    }
//		System.out.println("Total Products under sponsored are: " + productcount);
//	    
//	    }
//	@Test(priority=3)
//	public void TC__003() throws InterruptedException
//	{
//		List<WebElement> elem = driver.findElements(By.xpath("//a/span[contains(text(),'CETAPHIL')]/ancestor::div[1]/div[1]/span"));
//		int productcount = elem.size();
//		System.out.println("Total products linked with sponsored : " + productcount);
//		
//	}
//	
	
	
	
	
//	
//	@Test(priority=3)
//	public void TC__003() throws InterruptedException
//	{
//		
//		String productname="CETAPHIL";
//		
//	
//	List<WebElement> prod = driver.findElements(By.xpath("//a/span[contains(text(),'"+productname+"')]"));
//	int productcount = prod.size();
//	
//	
//	
//	List<WebElement> sponsored = driver.findElements(By.xpath("//a/span[contains(text(),'"+productname+"')]/ancestor::div[1]/div[1]/span"));
//	int sponsoredcount = sponsored.size();
//	
//	if(sponsoredcount==productcount)
//	
//	{
//		System.out.println("All the "+productname+"'s products appear as sponsored ");
//	}
//	
//	else
//	{
//		System.out.println("Not all the "+productname+"'s products appear as sponsored");
//		Assert.assertEquals( sponsoredcount,productcount);
//	}
//	
//	
//
//	}
	
	@Test(priority=3)
	
	public void TC__003() throws InterruptedException
	
	{
		
		String productname="CETAPHIL";
		String searchkey="Face Cream for dry skin";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchkey);
		Thread.sleep(1000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		
		
		
		
		
		
		List<WebElement> brandreslt = driver.findElements(By.xpath("//a/span[contains(text(),'"+productname+"')]"));
		int brandcount = brandreslt.size();
		/* This will retrieve all the products related to our brand enlisted in the search results*/
		

		List<WebElement> brandsponsored = driver.findElements(By.xpath("//a/span[contains(text(),'"+productname+"')]/ancestor::div[1]/div[1]/span"));
		int brandspcount = brandsponsored.size();
		
		
		if (brandcount==0)
		{
			System.out.println(""+productname+" is not listed in the search results");
			
		}
		
		else if (brandspcount==0)
		{
			System.out.println("There is no sponsored ads");
		}
		
		else if (brandcount==brandspcount)
		{
			System.out.println("All the "+productname+"'s products appear as sponsored ");
		}
		
		else 
		{
			System.out.println("Not all the "+productname+"'s products appear as sponsored");
		}
		System.out.println("Below are the List of products which comes under Sponsored ad");
		
		System.out.println("****************************************************************");
		List<WebElement> prod = driver.findElements(By.xpath("//a/span[contains(text(),'"+productname+"')]/ancestor::div[1]/div[1]/span/following::span[4]"));
	
		int productcount = prod.size();
		
		//for(int i=0; i<prod.size();i++)
		for (WebElement e : prod)
		{	
			String prdd=e.getText();
			
//			String product = e.findElement(By.xpath("//a/span[contains(text(),'CETAPHIL')]/ancestor::div[1]/div[1]/span/following::span[4]")).getText();
//			//String name= e.findElement(By.tagName("img")).getAttribute("alt");
			System.out.println(prdd);
			System.out.println("prodct count"+productcount);
//			//System.out.println(name);
//			
			
		}
		
	
	}
	
	
//	
//	
//	@AfterTest
//	public void teardown()
//	{
//		driver.quit();
//		
//	}
}
