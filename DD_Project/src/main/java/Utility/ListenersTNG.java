package Utility;

import java.io.File;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.beust.jcommander.Parameters;
import com.github.dockerjava.api.model.ContainerPort;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenersTNG implements ITestListener {
	public static WebDriver driver = null;
	public static Confid_File_Reader ob;
	
	public static WebDriver getWebDriver() throws InvalidPropertiesFormatException, IOException {
		ob = new Confid_File_Reader();
		driver = ob.getDriver("Chrome");
		return driver;
		
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart method started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method" + result.getName());
	}

	public void onTestFailure(ITestResult result) {		
		System.setProperty("org.uncommons.reportng.escape-output", "false") ;
		try {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dst = new File("C:\\Users\\user\\Desktop\\Selenium Batch Nov 25th\\Downloaded File\\Smaple001.jpeg");
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage" + result.getName());

	}
}
