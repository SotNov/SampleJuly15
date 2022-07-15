package ExtentReposrtsTc;

import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTc {
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	

	@BeforeMethod
	public void beforeClass() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./extentReport.html");
		test = extent.createTest("ExtentDemo");
		spark.config().setDocumentTitle("Testng Framework");
		spark.config().setReportName("Archana");
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
		extent.setSystemInfo("os", "windows");
		extent.setSystemInfo("env", "Qlab");
	}

	@Test
	public void ExtentDemo() {
		if (10 > 1) {
			test.log(Status.INFO, "Yes 10 is greater than 1");
		}
		
	}
	
	@AfterMethod
	public void afterMethod() {
		extent.flush();
	}

}
