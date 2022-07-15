package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page extends Gmail_Login_Page{

	public static WebDriver driver;
	public static By TO = By.xpath("//textarea[@aria-label='To']");
	public static By SUB = By.xpath("//input[@name='subjectbox']");
	public static By Cont = By.xpath("//div[@aria-label='Message Body']");
	public static By send_button = By.xpath("//div[@aria-label='Send ‪(Ctrl-Enter)‬']");
		
	
	public Home_Page(WebDriver driver) {
		this.driver=driver;
		Gmail_Login_Page GH = new Gmail_Login_Page();
		GH.gmail_Login_Mtd(driver);
	}
	
	public void compose_email(String To,String Sub,String Content) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(Gmail_Login_Page.ComposeBtn).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(TO).sendKeys(To);
		Thread.sleep(2000);
		driver.findElement(SUB).sendKeys(Sub);
		Thread.sleep(2000);
		driver.findElement(Cont).sendKeys(Content);
		Thread.sleep(2000);
		driver.findElement(send_button).click();		
	}
	

}
