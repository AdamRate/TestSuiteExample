package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggingPage {

	@FindBy (xpath = "//*[@id='draggableview']/p")
	private WebElement boxToDrag;
	
	@FindBy (xpath = "//*[@id='droppableview']")
	private WebElement dragTarget;
	
	
	public WebElement getBoxToDrag(){
		return boxToDrag;
	}
	
	public WebElement getDragTarget(){
		return dragTarget;
	}
	
	
}
