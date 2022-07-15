package Com.PAGES;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Gm_Login_Page {
	
	public static WebDriver driver;

	@FindBy(how=How.XPATH, using="//*[@type='email']")
	 public static WebElement Em_Id;
	
	// And Condition with respect to Xpath for Email Id
	/*@FindBys({
		@FindBy(name="identifier"),
		@FindBy(id="identifierId")
	})
	public static WebElement Em_Id;8?
	
	// Or Condition with respect to Xpath for Email Id
	/*@FindAll({
		@FindBy(name="identifier"),
		@FindBy(id="identrId")
	})	
	public static WebElement Em_Id;*/
	
	@FindBy(name="password")
	public static WebElement Em_Psw;
	
	@FindBy(xpath="//div[contains(text(),'Compose')]")
	public static WebElement Com_Btn;

	public  Gm_Login_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void LoginGm(String usr,String psd) {
		driver.get("https://gmail.com");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Em_Id.sendKeys(usr,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Em_Psw.sendKeys(psd,Keys.ENTER);
		if(Com_Btn.isDisplayed()) {
			System.out.println("Login Successful");
		}
		else {
			System.out.println("Login not Successful");
		}
		
	}

}
