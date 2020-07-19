package appPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseClasss.testBase;

public class LoginPage extends testBase {
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
	WebElement helloSingIn_btn;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email_textbox;

	@FindBy(xpath="//input[@type='password']")
	WebElement password_textbox;

	@FindBy(xpath="//input[@id='continue']")
	WebElement continue_btn;

	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement submit_btn;

	@FindBy(xpath="//a[@href='/ref=nav_logo']")
	WebElement amazonLogo;

	
	public String pageTitleVerification() {
		return driver.getTitle();
	}

	public boolean amazonLogoVerification() {
		return amazonLogo.isDisplayed();
	}
	
	public void login(String uid, String pwd) {
		helloSingIn_btn.click();
		email_textbox.sendKeys(uid);
		continue_btn.click();
		password_textbox.sendKeys(pwd);
		submit_btn.click();
	}

}
