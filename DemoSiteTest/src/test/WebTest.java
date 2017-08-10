package test;

import static org.junit.Assert.*;
import utils.SpreadSheetReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
	private WebDriver webDriver2;
	private SignUpPage signUpPage;
	private LoginPage loginPage;
	private NavBar navBar;
	private DraggingPage dragTest;
	private SortingPage sortingPage;
	private static ExtentReports report;
	private static ExtentTest test;
	private static String reportFilePath = "TEST.html";
	private WebElement successText;

	@BeforeClass
	public static void BeforeClass() {
		report = new ExtentReports();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
		extentHtmlReporter.config().setReportName("ReportName");
		extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
		report.attachReporter(extentHtmlReporter);
		test = report.createTest("TestName");
	}

	@Before
	public void Before() {


		System.out.println("Before");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		//webDriver2 = new FirefoxDriver();
		webDriver = new ChromeDriver(options);
		signUpPage = PageFactory.initElements(webDriver, SignUpPage.class);
		loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		navBar = PageFactory.initElements(webDriver, NavBar.class);
		dragTest = PageFactory.initElements(webDriver, DraggingPage.class);
		sortingPage = PageFactory.initElements(webDriver, SortingPage.class);

	}

	@Test
	public void DragTest() {
		webDriver.navigate().to("http://demoqa.com/droppable/");
		Actions builder = new Actions(webDriver);
		WebElement element = dragTest.getBoxToDrag();
		WebElement element2 = dragTest.getDragTarget();
		builder.moveToElement(element).clickAndHold().moveToElement(element2).release().perform();

		successText = webDriver.findElement(By.xpath("//*[@id='droppableview']/p"));
		assertEquals("Dropped!", successText.getText());
		
		if (successText.getText().equals("Dropped!")) {
			test.log(Status.PASS, "Box Dropped! ");
		} else
			test.log(Status.FAIL, "Box Not Dropped!");
	}
	
	@Test
	public void sortTest() {
		Actions builder = new Actions(webDriver);
		webDriver.navigate().to("http://demoqa.com/sortable/");	
		sortingPage.AddEls();
		sortingPage.getTab().click();
		sortingPage.moveBoxes(sortingPage.getBox(4), sortingPage.getBox(11), builder);
		test.log(Status.PASS, "Sort Test didnt break");
		
		try {
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "photo"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void LoginTest() {
		System.out.println("Test");
		String User;
		String pass;
		SpreadSheetReader ssr = new SpreadSheetReader("Book1.xlsx");
		List<String> row = ssr.readRow(1, "Sheet1");
		System.out.println("--Read Input: ");
		for (String cell : row) {
			System.out.println(cell);
		}

		System.out.println("--End of Read input--");

		webDriver.navigate().to("http://www.thedemosite.co.uk");
		navBar.goToAddUserPage();
		signUpPage.enterUsername(row.get(2));
		signUpPage.enterPassword(row.get(3));
		signUpPage.saveUser();
		navBar.goToLoginPage();
		loginPage.enterUsername(row.get(2));
		loginPage.enterPassword(row.get(3));
		loginPage.submitUserDetails();
		assertEquals("Login Successful", "**Successful Login**", loginPage.getSuccessText());

		if (loginPage.getSuccessText().equals("**Successful Login**")) {
			test.log(Status.PASS, "Test Passed for Username: " + row.get(2));
		} else
			test.log(Status.FAIL, "Test failed for Username: " + row.get(2));

		try {
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "photo"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		 test.log(Status.INFO,"Info level");

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


	  @Test public void FailTest() { test.log(Status.PASS, "TEst 3"); //
	  test.log(Status.WARNING, "Warning Message Test"); }
	 

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
