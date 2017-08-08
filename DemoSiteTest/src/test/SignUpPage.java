package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	
	@FindBy(xpath = "//input[contains(@name, 'username')]")
	private WebElement usernameInput;
	
	@FindBy(xpath = "//input[contains(@name, 'password')]")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//input[contains(@value, 'save')]")
	private WebElement saveButton;
	
	public void enterUsername(String username){
		usernameInput.sendKeys(username);
	}
	
	public void enterPassword(String password){
		passwordInput.sendKeys(password);
	}
	
	public void saveUser(){
		saveButton.click();
	}
	
}
