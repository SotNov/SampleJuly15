package Excel_Operations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExRunner {
	static String path = "C:\\Users\\user\\Desktop\\Selenium Batch Nov 25th\\Sample_Excel_Test_Data\\Test_Data.xlsx";
	
	public void getCredentialsAndLogin() throws IOException, InterruptedException {		
		ExRunner Obj = new ExRunner();
		int rownum = ExcelUtility.getRowCount(path, "Sheet1");
		String[][] logindata = new String[rownum][rownum];
		for (int i = 1; i <= rownum; i++) {
			int k=0,J=1;
			for(int j=0;j<=1;j++) {
			   
				logindata[k][j] = ExcelUtility.getCellData(path, "Sheet1", i, j);
			}
			String Usr = logindata[k][k];
			String Pass = logindata[k][J];
			System.out.println(Usr+" "+Pass);
			Obj.loginTest(Usr, Pass, i);
			}
		}

	public void loginTest(String user, String pwd, int row) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		int colcount = ExcelUtility.getcellCount(path, "Sheet1", 0);
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println(user);
		System.out.println(pwd);
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.id("btnLogin")).click();
		try {
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			WebElement Dashboard = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
			if (Dashboard.isDisplayed() == true) {
				String data = "PASS";
				System.out.println("Login successfull");
				ExcelUtility.setCellData(path, "Sheet1", row, colcount, data);
				driver.close();
			}

		} catch (Exception e) {
			System.out.println("Fail");
			String data = "Fail";
			System.out.println("Invalid Credentials");
			ExcelUtility.setCellData(path, "Sheet1", row, colcount, data);
			driver.close();
		}

	}

	public static void main(String args[]) throws InterruptedException, IOException {
		ExRunner Obj = new ExRunner();
		Obj.getCredentialsAndLogin();

	}
}
