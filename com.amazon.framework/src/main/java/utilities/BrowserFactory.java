package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BrowserFactory {
	
	public static WebDriver launchBrowser(WebDriver driver, String browser, String appUrl) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./browserDriver/chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Chrome Browser Running");
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./browserDriver/msedgedriver.exe");
			driver=new EdgeDriver();
			System.out.println("Edge Browser Running");
		}
		else {
			driver = new HtmlUnitDriver();
			System.out.println("Headless Browser Running");	
		}
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
}
