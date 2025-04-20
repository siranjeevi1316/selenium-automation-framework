package org.address;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address extends BaseClass {
	
	public Address() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	private WebElement fname;
	
	@FindBy(id="last-name")
	private WebElement lname;
	
	@FindBy(id="postal-code")
	private WebElement code;
	
	@FindBy(id="continue")
	private WebElement nxtcontinue;

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getCode() {
		return code;
	}

	public WebElement getNxtcontinue() {
		return nxtcontinue;
	}
	
	
	
	
	
	
	
	

}
