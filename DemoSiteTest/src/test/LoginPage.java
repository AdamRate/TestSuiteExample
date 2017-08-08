package test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage {



	@FindBy(xpath = "//input[contains(@name, 'username')]")
	private WebElement usernameInput;

	@FindBy(xpath = "//input[contains(@name, 'password')]")
	private WebElement passwordInput;

	@FindBy(xpath = "//input[contains(@value, 'Test Login')]")
	private WebElement submitButton;

	@FindBy(xpath = "//blockquote/blockquote/font/center/b")
	private WebElement successText;

	public void enterUsername(String username) {
		usernameInput.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void submitUserDetails() {
		submitButton.click();
	}

	public String getSuccessText() {
		return successText.getText();
	}
}
