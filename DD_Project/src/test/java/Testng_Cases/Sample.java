package Testng_Cases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.Confid_File_Reader;

public class Sample {
	public static WebDriver driver = null;

	@BeforeTest
	public void beforemethod() throws InvalidPropertiesFormatException, IOException {
		System.out.println("HHH");

	}
	@BeforeMethod
	public void beforeMethod() throws InvalidPropertiesFormatException, IOException {
		System.out.println("Sample Before Method");
		Confid_File_Reader ob = new Confid_File_Reader();
		driver = ob.getDriver("Chrome");
	}

	@Test(dependsOnGroups = "demo", groups = { "demo", "smoke" }, enabled = false)
	public static void sample() throws InvalidPropertiesFormatException, IOException {
		driver.get("https://gmail.com");
		System.out.println("Hello");
	}

	@Test (groups="demo")
	// (dependsOnGroups="demo")
	// (dependsOnMethods ={"h"})
	public void D() throws InvalidPropertiesFormatException, IOException {
		driver.get("https://gmail.com");
		System.out.println("DD");
		Thread.currentThread().setName("It Sample Thread");
		System.out.println(Thread.currentThread().getName());
	}

	@Test
	// (groups="demo")
	public static void h() throws InvalidPropertiesFormatException, IOException {
		driver.get("https://gmail.com");
		System.out.println("#090");
	}

}
