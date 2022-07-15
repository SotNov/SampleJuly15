package POM_PF_TC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.PAGES.Gm_Home_Page;
import Com.PAGES.Gm_Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Gm_Compose {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Gm_Login_Page G = new Gm_Login_Page(driver);
		Gm_Home_Page Gc = new Gm_Home_Page(driver);
		String USR="Sample28062022@gmail.com";
		String PSW="Selenium@999";
		G.LoginGm(USR, PSW);
		Gc.compseGmail(USR, "Page Factory", "Implementing Page Factory");
		driver.close();
	}

}
