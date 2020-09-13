/*		4. Verify the title of the second most popular course
		Goal: Read the title of the second most popular course on the website and verify the
		text
		a. Open a browser.
		b. Navigate to ‘https://alchemy.hguy.co/lms’.
		c. Get the title of the second most popular course.
		d. Make sure it matches “Email Marketing Strategies” exactly.
		e. If it matches, close the browser.*/

package testNGSeleniumProjectAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class VerifyTitlesecondmostPopularCourse_Act4 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/lms");
		driver.manage().window().maximize();
	}
	@Test
	public void VerifyTitlesecondmostPopularCourse() throws InterruptedException {
		
		
		  List<WebElement> elements = driver.findElements(By.cssSelector("h3.entry-title"));
				  
		  WebElement secelm = elements.get(1);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView(true);", secelm);
		  Thread.sleep(5000);
		  String sondmostPopularCourse = secelm.getText();
		  System.out.println("Read the title of the second most popular course on the website activity is :" + sondmostPopularCourse);
		  Reporter.log("Repoter Log"+sondmostPopularCourse , true);
		try {
			Assert.assertEquals(sondmostPopularCourse, "Email Marketing Strategies");
			Reporter.log("Expected Title found" , true);
			driver.close();
		}
		catch(Exception e) {
			System.out.println("Expected Title not found");
		}


	}


}
