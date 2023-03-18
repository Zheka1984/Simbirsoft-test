package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"first-name\"]")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"last-name\"]")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"postal-code\"]")
	WebElement zipCode;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	WebElement continueButton;

	public Checkout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillData(String firstName, String lastName, String zipCode) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.zipCode.sendKeys(zipCode);
	}
	public void continueBuy() {
		continueButton.click();
	}
	
}
