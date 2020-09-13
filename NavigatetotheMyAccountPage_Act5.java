/*			5. Navigate to another page
			Goal: Navigate to the “My Account” page on the site.
			a. Open a browser.
			b. Navigate to ‘https://alchemy.hguy.co/lms’.
			c. Find the navigation bar.
			d. Select the menu item that says “My Account” and click it.
			e. Read the page title and verify that you are on the correct page.
			f. Close the browser.*/

package testNGSeleniumProjectAssignment;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class NavigatetotheMyAccountPage_Act5 {
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
		
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
		elem.click();
		
		String curpageTitle = driver.getTitle();
		System.out.println("The title of the current page : "+curpageTitle);
		try {
			Assert.assertEquals(curpageTitle, "My Account – Alchemy LMS");
			Reporter.log("Expected Page Title found" , true);
			
		}
		catch(Exception e) {
			System.out.println("Expected Title not found");
		}


	}
	
	@AfterClass
	public void afterClass() { 
		driver.close();
	}
}
