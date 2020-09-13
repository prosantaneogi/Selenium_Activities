/*		Logging into the site
		Goal: Open the website and log-in using the provided credentials.
		a. Open a browser.
		b. Navigate to ‘https://alchemy.hguy.co/lms’.
		c. Find the navigation bar.
		d. Select the menu item that says “My Account” and click it.
		e. Read the page title and verify that you are on the correct page.
		f. Find the “Login” button on the page and click it.
		g. Find the username field of the login form and enter the username into that field.
		h. Find the password field of the login form and enter the password into that field.
		i. Find the login button and click it.
		j. Verify that you have logged in.
		k. Close the browser.
*/
package testNGSeleniumProjectAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

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


public class NavigatetotheMyAccountPage_Act6 {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js; 

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
		driver.get("https://alchemy.hguy.co/lms");
		driver.manage().window().maximize();
	}
	
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "root", "pa$$w0rd" }};
    }
	@Test(dataProvider = "Authentication")
	public void VerifyTitlesecondmostPopularCourse(String username , String password) throws InterruptedException {
		
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
		elem.click();
		
		String curpageTitle = driver.getTitle();
		System.out.println("The title of the current page : "+curpageTitle);
		try {
			Assert.assertEquals(curpageTitle, "My Account – Alchemy LMS");
			Reporter.log("Expected Page Title found" , true);
			WebElement loginlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
			loginlink.click();
			
			WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
			uname.sendKeys(username);
			WebElement pword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_pass")));
			pword.sendKeys(password);
			WebElement loginbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-submit")));
			loginbtn.click();
		
			WebElement Logoutbtn = driver.findElement(By.linkText("Logout"));
			js.executeScript("arguments[0].scrollIntoView(true);", Logoutbtn);			
				try {
					Assert.assertTrue(Logoutbtn.isDisplayed());
					System.out.println("Logged in successfully");
				}
				catch(Exception e) {
					System.out.println("Unable to login");
				}
		}
		catch(Exception e) {
			System.out.println("Test Case got Failed");
		}
		
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}


}
