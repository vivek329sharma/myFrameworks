package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	
	public ConfigDataProvider() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/main/java/cofigProperties/congif.properties");
			prop.load(fis);
			System.out.println("Config Properties File Loaded");
		} catch (Exception e) {
			System.out.println("Unable to load Config Properties File"+e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public String getStagingUrlFromConfig() {
		return prop.getProperty("QaURL");
	}

	public String getBrowserFromConfig() {
		return prop.getProperty("Browser");
	}
	
	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}
	
}
