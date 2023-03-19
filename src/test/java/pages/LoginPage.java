package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(css = "input#user-name")
	WebElement userName;

	@FindBy(css = "input#password")
	WebElement password;

	@FindBy(css = "input#login-button.submit-button.btn_action")
	WebElement login;

	@FindBy(css = ".error-message-container > h3:nth-child(1)")
	WebElement error;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logIn(String user, String password) {
		userName.sendKeys(user);
		this.password.sendKeys(password);
		login.click();
	}

	public String getError() {
		return error.getText();
	}

}
