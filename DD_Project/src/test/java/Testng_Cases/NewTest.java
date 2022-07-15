package Testng_Cases;

import org.testng.annotations.Test;

import Utility.Confid_File_Reader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	public static WebDriver driver;
 
	@Test
  public void f() {
	  System.out.println("This is Test");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is AfterMethod");
	  
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is AfterClass");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is AfterTest");
  }

  @BeforeSuite
  public static void beforeSuite(){
	  System.out.println("BeforeSuite");
		
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");
  }

}


/*
 *@BeforeSuite
@BeforeTest
@BeforeClass
@BeforeMethod
@Test
@AfterMethod
@AfterClass
@AfterTest
@AfterSuite
*/
