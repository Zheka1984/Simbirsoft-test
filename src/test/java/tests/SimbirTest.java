package tests;

import java.time.Duration;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(OrderAnnotation.class)
public class SimbirTest {
	
	static WebDriver driver;
	LoginPage logPage;
	PurchasePage ppage;
	ShoppingCart shcart;
	Checkout chpage;
	Confirmation confPage;
	FinishPage fpage;

	@BeforeAll
	static void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeEach
	void start() {
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	@Order(1)
	void testPurchase() {
	logPage = new LoginPage(driver);
	logPage.logIn("standard_user", "secret_sauce");
	ppage = new PurchasePage(driver);
	ppage.purchaseFirstIten();
	ppage.clickToBasket();
	shcart = new ShoppingCart(driver);
	shcart.clickOnCheckOut();
	chpage = new Checkout(driver);
	chpage.fillData("test", "test", "test");
	chpage.continueBuy();
	confPage = new Confirmation(driver);
	confPage.confirm();
	fpage = new FinishPage(driver);
	assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
	assertEquals(fpage.message(), "Thank you for your order!");
	}
	@Test
	@Order(2)
	void testError() {
		logPage = new LoginPage(driver);
		logPage.logIn("test", "test");
		assertEquals(logPage.getError(), "Epic sadface: Username and password do not match any user in this service");
	}
	
}
