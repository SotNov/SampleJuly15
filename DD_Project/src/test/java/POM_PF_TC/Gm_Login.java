package POM_PF_TC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.PAGES.Gm_Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Gm_Login {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Gm_Login_Page G = new Gm_Login_Page(driver);
		String USR="Sample28062022@gmail.com";
		String PSW="Selenium@999";
		G.LoginGm(USR, PSW);
		driver.close();

	}

}
