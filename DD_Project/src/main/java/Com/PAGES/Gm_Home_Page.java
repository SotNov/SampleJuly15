package Com.PAGES;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.PAGES.Gm_Login_Page;

import Pages.Gmail_Login_Page;

public class Gm_Home_Page {
	public WebDriver driver;

	@FindBy(xpath = "//textarea[@aria-label='To']")
	public static WebElement To;

	@FindBy(xpath = "//input[@name='subjectbox']")
	public static WebElement Sub;

	@FindBy(xpath = "//div[@aria-label='Message Body']")
	public static WebElement Cot;

	@FindBy(xpath = "//div[@aria-label='Send ‪(Ctrl-Enter)‬']")
	public static WebElement SendBtn;

	public Gm_Home_Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void compseGmail(String to, String sub, String cont) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Gm_Login_Page.Com_Btn.click();
		Thread.sleep(2000);
		To.sendKeys(to);
		Thread.sleep(2000);
		Sub.sendKeys(sub);
		Thread.sleep(2000);
		Cot.sendKeys(cont);
		Thread.sleep(2000);
		SendBtn.click();
	}
}
