package org.product.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseClass {
	
public ProductPage() {
	PageFactory.initElements(driver, this);
}

		@FindBy(id="add-to-cart-sauce-labs-backpack")
		private WebElement addbackpack;
		
		@FindBy(id="add-to-cart-sauce-labs-bike-light")
		private WebElement addlight;
		
		@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
		private WebElement addtshirt;

		@FindBy(id="shopping_cart_container")
		private WebElement addtocart;
		
		@FindBy(id="checkout")
		private WebElement checkout;
		
		
		public WebElement getAddtocart() {
			return addtocart;
		}

		public WebElement getCheckout() {
			return checkout;
		}

		public WebElement getAddbackpack() {
			return addbackpack;
		}

		public WebElement getAddlight() {
			return addlight;
		}

		public WebElement getAddtshirt() {
			return addtshirt;
		}
























}
