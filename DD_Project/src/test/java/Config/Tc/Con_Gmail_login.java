package Config.Tc;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Confid_File_Reader;

public class Con_Gmail_login {

	public static void main(String[] args) throws InvalidPropertiesFormatException, IOException, InterruptedException {
		
		// Code with respect to config properties file withOut By method for locator
		/*Confid_File_Reader ob = new Confid_File_Reader();
		WebDriver driver = ob.getDriver("Chrome");
		driver.get(ob.getUrl());
		ob.ImplicitWait();
		Thread.sleep(3000);
		WebElement emailid = ob.getLocators("UserId");
		emailid.sendKeys("Sample28062022@gmail.com", Keys.ENTER);*/

		// Code with respect to config properties file using By method for locator		
		/* Confid_File_Reader ob = new Confid_File_Reader(); 
		 WebDriver driver =ob.getDriver("Chrome"); 		
		 driver.get(ob.getUrl()); 
		 ob.ImplicitWait();
		 Thread.sleep(3000); 		 
		 WebElement emailid= driver.findElements(ob.getLocatorsUsingBy("UserId"));
		   emailid.sendKeys("Sample28062022@gmail.com", Keys.ENTER);
		 List<WebElement> emailid = driver.findElements(ob.getLocatorsUsingBy("UserId"));
		 emailid.get(0).sendKeys("Sample28062022@gmail.com", Keys.ENTER); */
	}

}
