package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"finish\"]")
	WebElement finishButton;

	public Confirmation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void confirm() {
		finishButton.click();
	}

}
