package org.demo.ecommerce;

import java.util.Date;

import org.address.Address;
import org.base.BaseClass;
import org.demo.pages.LoginPage;
import org.product.page.ProductPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseApp extends BaseClass {
		
	
	@BeforeClass
	public void beforeClass() {
		browserLaunch("chrome");
		implicityWait(15);
		System.out.println("Before Class Run");
	}
	
	@AfterClass
	public void afterClass() {
		quit();
		System.out.println("After Class Run");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Test Start : "+new Date());
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Test Start : "+new Date());
		System.out.println("After Method");
	}
	
	@Test
	public void test() {
			urlLaunch("https://www.saucedemo.com");
			implicityWait(15);
			LoginPage l = new LoginPage();
			sendKeys(l.getUser(), "standard_user");
			sendKeys(l.getPass(), "secret_sauce");
			click(l.getBtnLogin());
			ProductPage p =new ProductPage();
			click(p.getAddbackpack());
			click(p.getAddlight());
			click(p.getAddtshirt());
			click(p.getAddtocart());
			click(p.getCheckout());
			Address a = new Address();
			sendKeys(a.getFname(), "Luffy");
			sendKeys(a.getLname(), "Monkey D");
			sendKeys(a.getCode(), "543678");
			click(a.getNxtcontinue());
			System.out.println("Automation Completed");
			System.out.println("Test Completed");
			
			
			
	}		
			
	}		
			
			
			
			
			
	