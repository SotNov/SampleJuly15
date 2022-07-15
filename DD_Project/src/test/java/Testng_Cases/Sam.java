package Testng_Cases;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Sam {

	@Test
	//(groups="Smoke")
	public static void DD() {
		System.out.println("DDoo");
		Reporter.log("Hello Done with execution");
	}

}
