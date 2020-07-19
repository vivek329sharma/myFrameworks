package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	//screenshot, alerts, frames, sync issues, jsexecutor
	
	public static String captureScreenshots(WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String sscreenshotPath = System.getProperty("user.dir")+"/screenshots/amazon_"+getCurrentDateTime()+".png";
		try {
			FileUtils.copyFile(src, new File(sscreenshotPath));
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			System.out.println("Screenshot was not taken"+e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return sscreenshotPath;
	}
	
public static String getCurrentDateTime() {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yyyy_HH_mm_ss");
	LocalDateTime now = LocalDateTime.now();
//	System.out.println(dtf.format(now));
	return dtf.format(now);
	}
}
