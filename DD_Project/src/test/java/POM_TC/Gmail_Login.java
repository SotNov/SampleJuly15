package POM_TC;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Utility.Confid_File_Reader;

import Pages.Gmail_Login_Page;
import Pages.Home_Page;
import Utility.Confid_File_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Gmail_Login {

	public static void main(String[] args) throws InvalidPropertiesFormatException, IOException, InterruptedException {
		
		// Code using POM
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String USR = "Sample28062022@gmail.com";
		String PSW = "Selenium@999";
		Home_Page GML = new Home_Page(driver);
		GML.gmail_Login_Mtd(driver);
		GML.Login(USR, PSW);
		driver.close();
	}

}
