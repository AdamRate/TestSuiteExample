package test;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SortingPage {

	public void AddEls() {
		lists.add(box1); // 0
		lists.add(box2); // 1
		lists.add(box3); // 2
		lists.add(box4); // 3
		lists.add(box5); // 4
		lists.add(box6); // 5
		lists.add(box7); // 6
		lists.add(box8); // 7
		lists.add(box9); // 8
		lists.add(box10); // 9
		lists.add(box11); // 10
		lists.add(box12); // 11
	}

	ArrayList<WebElement> lists = new ArrayList<>();

	@FindBy(xpath = "//*[@id='ui-id-3']")
	private WebElement Tab;

	@FindBy(xpath = "//*[@id='sortable_grid']/li[1]")
	private WebElement box1;

	@FindBy(xpath = "//*[@id='sortable_grid']/li[2]")
	private WebElement box2;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[3]")
	private WebElement box3;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[4]")
	private WebElement box4;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[5]")
	private WebElement box5;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[6]")
	private WebElement box6;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[7]")
	private WebElement box7;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[8]")
	private WebElement box8;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[9]")
	private WebElement box9;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[10]")
	private WebElement box10;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[11]")
	private WebElement box11;
	@FindBy(xpath = "//*[@id='sortable_grid']/li[12]")
	private WebElement box12;

	public WebElement getTab() {
		return Tab;
	}

	public WebElement getBox(int a) {
		if (a <= 11) {
			return lists.get(a);
		} else
			return lists.get(0);
	}

	public WebElement getBox1() {
		return box1;
	}

	public WebElement getBox2() {
		return box2;
	}

	public WebElement getBox3() {
		return box3;
	}

	public WebElement getBox4() {
		return box4;
	}

	public WebElement getBox5() {
		return box5;
	}

	public WebElement getBox6() {
		return box6;
	}

	public WebElement getBox7() {
		return box7;
	}

	public WebElement getBox8() {
		return box8;
	}

	public WebElement getBox9() {
		return box9;
	}

	public WebElement getBox10() {
		return box10;
	}

	public WebElement getBox11() {
		return box11;
	}

	public WebElement getBox12() {
		return box12;
	}

	public void moveBoxes(WebElement a, WebElement b, Actions c) {
		c.moveToElement(a).clickAndHold().moveByOffset(calcOffsetX(a, b, c), 0).perform();
		c.moveByOffset(0, calcOffsetY(a, b, c)).release().perform();
	}

	public int calcOffsetX(WebElement a, WebElement b, Actions c) {
		int x;
		x = (b.getLocation().getX() - a.getLocation().getX()) - 10;

		if (x<0){
			x= x-10;
		}
		else
			x= x +10;
		System.out.println(x);
		return x;
	}

	public int calcOffsetY(WebElement a, WebElement b, Actions c) {
		int y;
		y = (b.getLocation().getY() - a.getLocation().getY());
		if (y <= 0) {
			y = y - 10;
		} else {
			y = y + 10;
		}

		System.out.println(y);
		return y;
	}
}
