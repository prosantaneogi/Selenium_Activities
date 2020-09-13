/*			2. Verify the website heading
			Goal: Read the heading of the website and verify the text
			a. Open a browser.
			b. Navigate to ‘https://alchemy.hguy.co/lms’.
			c. Get the heading of the webpage.
			d. Make sure it matches “Learn from Industry Experts” exactly.
			e. If it matches, close the browser*/

package testNGSeleniumProjectAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class VerifytheWebsiteHeading_Act2 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		driver.manage().window().maximize();
	}
	@Test
	public void VerifytheWebsiteHeading() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.uagb-ifb-title")));

		String headingofthePage = elm.getText();
		System.out.println("The title of the page for Verifythewebsitetitle activity is :" + headingofthePage);
		Reporter.log(headingofthePage);
		try {
			Assert.assertEquals(headingofthePage, "Learn from Industry Experts");
			Reporter.log("Expected header found");
			driver.close();
		}
		catch(Exception e) {
			System.out.println("Expected header not found");
		}


	}


}
