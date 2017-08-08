package test;

import static org.junit.Assert.*;

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
	private ExtentReports report;
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

		System.out.println("Test");
		webDriver.navigate().to("http://www.TheDemoSite.co.uk");
		navBar.goToAddUserPage();
		signUpPage.enterUsername("Test");
		signUpPage.enterPassword("Password");
		signUpPage.saveUser();
		navBar.goToLoginPage();
		loginPage.enterUsername("Test");
		loginPage.enterPassword("Password");
		loginPage.submitUserDetails();
		assertEquals("**Successful Login**", loginPage.getSuccessText());

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

	@Test
	public void FailTest() {
		// test.log(Status.WARNING, "Failure");
	}

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
