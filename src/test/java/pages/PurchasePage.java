package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	WebElement firstProductToCart;

	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
	WebElement basket;

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void purchaseFirstIten() {
		firstProductToCart.click();
	}

	public void clickToBasket() {
		basket.click();
	}
}
