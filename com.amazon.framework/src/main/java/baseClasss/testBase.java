package baseClasss;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.BrowserFactory;
import utilities.ConfigDataProvider;
import utilities.ExcelDataProvider;
import utilities.Helper;

public class testBase {
	
	public WebDriver driver;
	public ExcelDataProvider readExcel;
	public String username, password;
	public ConfigDataProvider readConfig;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void dataSetUp() {
		readExcel = new ExcelDataProvider();
		readConfig = new ConfigDataProvider();
		
		username = readExcel.getStringData("Login", 1, 0);
		password = readExcel.getStringData(0, 1, 1);
		System.out.println("My Amazon Username & Password are : "+username +" & "+password);
		
		ExtentHtmlReporter extentReporter = new ExtentHtmlReporter("./reports/amazon_"+ Helper.getCurrentDateTime() +".html");
		report = new ExtentReports();
		report.attachReporter(extentReporter);
	}
	
	@BeforeClass
	public void browserSetUp() {
		driver = BrowserFactory.launchBrowser(driver,readConfig.getBrowserFromConfig(), readConfig.getStagingUrlFromConfig());
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void closeApplication() {
		BrowserFactory.closeBrowser(driver);
	}
	
	@AfterMethod
	public void captureScreenshot(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
//			Helper.captureScreenshots(driver); //captures ss without report
			logger.fail("Failed Test Case", MediaEntityBuilder.createScreenCaptureFromPath
					(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Passed Test Case", MediaEntityBuilder.createScreenCaptureFromPath
					(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip("Skipped Test Case", MediaEntityBuilder.createScreenCaptureFromPath
					(Helper.captureScreenshots(driver)).build());
		}
		report.flush();
	}
	
	public void waitFor(int sec) throws Exception {
		Thread.sleep(sec*1000);
	}

}