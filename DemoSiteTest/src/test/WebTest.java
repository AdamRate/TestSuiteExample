package test;

import static org.junit.Assert.*;
import utils.SpreadSheetReader;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.junit.Before;
import org.openqa.selenium.*;

public class WebTest {

	private WebDriver webDriver;
	private SignUpPage signUpPage;
	private LoginPage loginPage;
	private NavBar navBar;
	private static ExtentReports report;
	private ExtentTest test;
	private String reportFilePath = "TEST.html";

	@BeforeClass
	public static void BeforeClass() {

	}

	@Before
	public void Before() {
		report = new ExtentReports();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
		extentHtmlReporter.config().setReportName("ReportName");
		extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
		report.attachReporter(extentHtmlReporter);
		test = report.createTest("TestName");

		System.out.println("Before");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver(options);
		signUpPage = PageFactory.initElements(webDriver, SignUpPage.class);
		loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		navBar = PageFactory.initElements(webDriver, NavBar.class);

	}

	@Test
	public void LoginTest() {
		String User;
		String pass;
		SpreadSheetReader ssr = new SpreadSheetReader("Book1.xlsx");
		List<String> row = ssr.readRow(1, "Sheet1");
		System.out.println("--Read Input: ");
		for (String cell : row) {
			System.out.println(cell);

		}
		System.out.println("--End of Read input--");

		System.out.println("Test");

		webDriver.navigate().to("http://www.TheDemoSite.co.uk");
		navBar.goToAddUserPage();
		signUpPage.enterUsername(row.get(2));
		signUpPage.enterPassword(row.get(3));
		signUpPage.saveUser();
		navBar.goToLoginPage();
		loginPage.enterUsername(row.get(2));
		loginPage.enterPassword(row.get(3));
		loginPage.submitUserDetails();
		assertEquals("Login Successful", "**Successful Login**", loginPage.getSuccessText());
		
		if (loginPage.getSuccessText().equals("**Successful Login**")){
		test.log(Status.PASS, "Test Passed for Username: "+ row.get(2));
		}
		else test.log(Status.FAIL,"Test failed for Username: " + row.get(2));
	
		
		
		try {
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "photo"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// test.log(Status.INFO,"Info level");

		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
		 * .withTimeout(10, TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS)
		 * .ignoring(NoSuchElementException.class);
		 * 
		 * WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		 * 
		 * public WebElement apply(WebDriver driver) { return
		 * webDriver.findElement(By.xpath(
		 * "//blockquote/blockquote/font/center/b"));
		 * 
		 * } });
		 */

	}

	/*
	 * @Test public void FailTest() { test.log(Status.PASS, "TEst 3"); //
	 * test.log(Status.WARNING, "Failure"); }
	 */

	@After
	public void After() {
		report.flush();
		webDriver.quit();
		System.out.println("After");
	}

	@AfterClass
	public static void AfterClass() {

	}

}
