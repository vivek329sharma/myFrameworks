package appPagesTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import appPages.LoginPage;
import baseClasss.testBase;

public class LoginPageTest extends testBase {

	@Test(priority=1)
	public void loginToAmazonTest() throws Exception {

		logger = report.createTest("Login To Amazon Test");
		logger.info("Testing Started");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.pageTitleVerification();
		loginPage.amazonLogoVerification();

		loginPage.login(username, password);

		logger.pass("Login Success");
	}
	
	@Test(priority=2)
	public void amazonLogoTitleTest() {
		logger = report.createTest("Amazon Logo & Title Test");
		logger.fail("Testing Failed");
	}
}
