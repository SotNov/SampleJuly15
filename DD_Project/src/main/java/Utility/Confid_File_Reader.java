package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// This reads Objects from properties file so properties file is called Object repository
public class Confid_File_Reader {
	private FileInputStream fis;
	public final String ConfigFile = "Config//Configarations.properties";
	private Properties properties;
	public WebDriver driver;

	public Confid_File_Reader() throws InvalidPropertiesFormatException, IOException {
		fis = new FileInputStream(ConfigFile);
		properties = new Properties();
		try {
			properties.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Locator not found at property file" + " " + ConfigFile);
		}
	}

	public WebElement getLocators(String LocatorName) throws InvalidPropertiesFormatException, IOException {
		WebElement Element = null;
		String Locator = properties.getProperty(LocatorName);
		String Loc = Locator.toString();
		String LocType = Loc.split(":")[0];
		String LocValue = Loc.split(":")[1];

		switch (LocType) {
		case "Xpath":
			Element = driver.findElement(By.xpath(LocValue));
			break;

		case "Name":
			Element = driver.findElement(By.name(LocValue));
			break;
		case "Id":
			Element = driver.findElement(By.id(LocValue));
			break;

		}
		return Element;

	}

	public By getLocatorsUsingBy(String LocatorName) {
		String LocName = properties.getProperty(LocatorName);
		String str = LocName.toString();
		String LocatorType = str.split(":")[0];
		String LocatorValue = str.split(":")[1];
		By Locator = null;
		switch (LocatorType) {
		case "Xpath":
			Locator = By.xpath(LocatorValue);
			break;
		}
		return Locator;

	}

	public WebDriver getDriver(String driverType) {

		switch (driverType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			break;
		}
		return driver;

	}

	public String getUrl() {
		String url = properties.getProperty("url");
		return url;

	}

	public void ImplicitWait() {
		int wait = Integer.parseInt(properties.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
}
