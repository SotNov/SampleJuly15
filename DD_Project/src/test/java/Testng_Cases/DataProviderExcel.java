package Testng_Cases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Lo4jTc.log_Tc;
import Utility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExcel {

	WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test, test1;
	private static org.apache.log4j.Logger log = Logger.getLogger(DataProviderExcel.class);

	@BeforeTest
	public void setUpTest() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./extentReport.html");
		test = extent.createTest("ExtentTc");
		test1 = extent.createTest("ExtentTc1");
		spark.config().setDocumentTitle("Testng Framework");
		spark.config().setReportName("Archana");
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
		extent.setSystemInfo("os", "macos");
		extent.setSystemInfo("env", "Qlab");
	}

	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {
		try {
			log.info("User name has been retrived");
			System.out.println(user);
			log.info("This retrived Password");
			System.out.println(pwd);
			driver.findElement(By.id("txtUsername")).click();
			driver.findElement(By.id("txtUsername")).sendKeys(user);
			log.info("User name fetched");
			driver.findElement(By.id("txtPassword")).click();
			driver.findElement(By.id("txtPassword")).sendKeys(pwd, Keys.ENTER);
			log.info("Password name fetched");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(4000);
			WebElement Dashboard = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
			if (Dashboard.isDisplayed() == true) {
				test.log(Status.PASS, "Login sucessefull");
				log.trace("Login sucessefull");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Login not sucessefull");
			log.error("Login failed" + " " + user + " " + pwd);
			test.addScreenCaptureFromPath("/.Failure.jpeg", "FailuereScreenshot");
		}

	}

	@AfterMethod
	void closeBrowser() {
		driver.close();
		extent.flush();
	}

	@Test
	public void sampleTest() {
		if (10 > 5) {
			test1.log(Status.PASS, "Yes 10 is greater than 5");
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\user\\Desktop\\Selenium Batch Nov 25th\\Sample_Excel_Test_Data\\Test_Data.xlsx";
		int rownum = ExcelUtility.getRowCount(path, "Sheet1");
		int colcount = ExcelUtility.getcellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = ExcelUtility.getCellData(path, "Sheet1", i, j);

			}
		}

		return logindata;

	}

}
