package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar {
	
	@FindBy(xpath = "//a[contains(@href,'addauser.php')]")
	private WebElement GoToAddUserPage;
	
	@FindBy(xpath = "//a[contains(@href,'login.php')]")
	private WebElement GoToLoginPage;

	public void goToAddUserPage(){
		GoToAddUserPage.click();
	}
	
	public void goToLoginPage() {
		GoToLoginPage.click();
	}

}
