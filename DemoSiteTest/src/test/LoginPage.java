package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath= "//input[contains(@name, 'username')]")
	private WebElement usernameInput;
	
	@FindBy (xpath = "//input[contains(@name, 'password')]")
	private WebElement passwordInput;
	
	@FindBy (xpath="//input[contains(@value, 'Test Login')]")
	private WebElement submitButton;

	@FindBy (xpath="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement successText;
	
	public void enterUsername(String username){
		usernameInput.sendKeys(username);
	}
	
	public void enterPassword(String password){
		passwordInput.sendKeys(password);
	}
	
	public void submitUserDetails(){
		submitButton.click();
	}
	
	public String getSuccessText(){
		return successText.getText();
	}
}
