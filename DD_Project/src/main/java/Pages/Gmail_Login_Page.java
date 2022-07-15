package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gmail_Login_Page {

	public static WebDriver driver;
	
	public static By Email_Id = By.xpath("//*[@type='email']");
	public static By ComposeBtn = By.xpath("//div[contains(text(),'Compose')]");
	public static By PSD = By.xpath("//input[@aria-label='Enter your password']");
	
	public void gmail_Login_Mtd(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Login(String User, String Password) {
		try {
			driver.get("https://gmail.com");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(Email_Id).sendKeys(User,Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(PSD).sendKeys(Password,Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			WebElement Compose_Btn = driver.findElement(ComposeBtn);
			if(Compose_Btn.isDisplayed()) {
				System.out.println("Login Successful");
			}
			
		} catch (Exception e) {
			System.out.println("Login not Successful");
			
		}
		
		
	}

}
