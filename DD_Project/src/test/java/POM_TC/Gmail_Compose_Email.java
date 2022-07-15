package POM_TC;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Gmail_Login_Page;
import Pages.Home_Page;
import Utility.Confid_File_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail_Compose_Email {
    @Test
	public void test() throws InterruptedException, InvalidPropertiesFormatException, IOException {
		Confid_File_Reader ob = new Confid_File_Reader();
		WebDriver driver = ob.getDriver("Chrome");
		String USR = "Sample28062022@gmail.com";
		String PSW = "Selenium@999";
		Home_Page GHP = new Home_Page(driver);
		GHP.Login(USR, PSW);
		GHP.compose_email(USR, "TEST MAIL", "This is the test mail");
		driver.close();
	}
}
