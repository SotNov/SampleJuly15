package Testng_Cases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import Excel_Operations.ExRunner;
import Utility.Confid_File_Reader;
import Utility.ExcelUtility;
import Utility.ListenersTNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListenersTNG.class)
public class Gmail_Login_tetng {
	WebDriver driver = null;

	public WebDriver getDriverFromListeners() throws InvalidPropertiesFormatException, IOException {
		this.driver = ListenersTNG.getWebDriver();
		return driver;

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "First-Value" }, { "Second-Value" } };
	}

	@Test(dataProvider = "data-provider")
	public void myTest(String val) {
		System.out.println("Passed Parameter Is : " + val);
	}

	@BeforeTest
	public void beforetest() throws InvalidPropertiesFormatException, IOException {
		System.out.println("Sample Before Test");
		driver = getDriverFromListeners();
	}

	@AfterTest
	public void AfterTest() {
		if (driver != null) {
			driver.close();
		}
	}

	@Test
	public void A() throws InterruptedException, InvalidPropertiesFormatException, IOException {
		System.out.println("A");
		driver.get("https://google.com");
		String Tit = driver.getTitle();
		System.out.println(Tit);
		Thread.sleep(5000);
		//Assert.assertEquals("Gmail", Tit);
		SoftAssert softAssert = new SoftAssert();		
		softAssert.assertEquals("Gmail", Tit);
		System.out.println("This is to check assert execution");
	}

	@Test
    @Parameters ({"BROWSER"})
	public void getTheParameterValue(String browserType) {
		System.out.println(browserType);
	}
	

}
