		/*1. Verify the website title
		Goal: Read the title of the website and verify the text
		a. Open a browser.
		b. Navigate to ‘https://alchemy.hguy.co/lms’.
		c. Get the title of the website.
		d. Make sure it matches “Alchemy LMS – An LMS Application '' exactly.
		e. If it matches, close the browser.*/

package testNGSeleniumProjectAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class VerifytheWebsiteTitle_Act1 {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		driver.manage().window().maximize();
	}
	@Test
	public void VerifytheWebsiteTitle() {

		String titleofthePage = driver.getTitle();
		System.out.println("The title of the page for Verifythewebsitetitle activity is :" + titleofthePage);
		Reporter.log(titleofthePage);
		try {
			Assert.assertEquals(titleofthePage, "Alchemy LMS – An LMS Application");
			Reporter.log("Expected Title found");
			driver.close();
		}
		catch(Exception e) {
			System.out.println("Expected header not found");
			Reporter.log("Expected Title not found");
		}


	}


}
