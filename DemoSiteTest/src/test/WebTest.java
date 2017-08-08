package test;

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
		webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")).click();	
		webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys("Test");
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys("Password");
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
		webDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("Test");
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys("Password");
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
	}
	
	@After
	public void After(){
		System.out.println("After");
	}
	
}
