package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;
import org.openqa.selenium.*;

public class WebTest {
	
	private WebDriver webDriver;
	
	@Before
	public void Before(){
		System.out.println("Before");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver(options);
	}
	
	@Test
	public void Test(){
		System.out.println("Test");
		webDriver.navigate().to("http://www.TheDemoSite.co.uk");	
		webDriver.findElement(By.xpath("//a[contains(@href,'addauser.php')]")).click();			 				// Go to Create Login Page
		webDriver.findElement(By.xpath("//input[contains(@name, 'username')]")).sendKeys("Test");				//Find Username field. Send a Username
		webDriver.findElement(By.xpath("//input[contains(@name, 'password')]")).sendKeys("Password");			//Find Password field. Send a Password
		webDriver.findElement(By.xpath("//input[contains(@value, 'save')]")).click();							//Click save button
		webDriver.findElement(By.xpath("//a[contains(@href,'login.php')]")).click();							//Go to Login Page
		webDriver.findElement(By.xpath("//input[contains(@name, 'username')]")).sendKeys("Test");				//Find Username field. Send a Username
		webDriver.findElement(By.xpath("//input[contains(@name, 'password')]")).sendKeys("Password");			//Find Password field. Send a Password
		webDriver.findElement(By.xpath("//input[contains(@value, 'Test Login')]")).click();
		assertEquals("**Successful Login**", webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());				 //Check login was successful
		
	}
	
	@After
	public void After(){
		//webDriver.quit();
		System.out.println("After");
	}
	
}
