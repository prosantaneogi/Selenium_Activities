			/*		9. Complete a simple lesson
			Goal: Navigate to a particular lesson and complete it.
			a. Open a browser.
			b. Navigate to ‘https://alchemy.hguy.co/lms’.
			c. Find the navigation bar.
			d. Select the menu item that says “All Courses” and click it.
			e. Select any course and open it.
			f. Click on a lesson in the course. Verify the title of the course.
			g. Click the Mark Complete button on the page (if available).
			h. Close the browser.*/


package testNGSeleniumProjectAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
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


public class CompleteSimpleLesson_Act9 {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js; 

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
		driver.get("https://alchemy.hguy.co/lms");
		driver.manage().window().maximize();
	}
	
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "root", "pa$$w0rd" }};
    }
	
	@Test(dataProvider = "Authentication")
	public void Completelesson(String username , String password) throws InterruptedException {

		try {

			WebElement myacc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
			myacc.click();
			WebElement loginlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
			loginlink.click();
			
			WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
			uname.sendKeys(username);
			WebElement pword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_pass")));
			pword.sendKeys(password);
			WebElement loginbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-submit")));
			loginbtn.click();
	
			WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Courses")));
			elem.click();
			
			List<WebElement> courses = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']/div"));
			courses.get(0).click();
			WebElement expall = driver.findElement(By.xpath("*//span[text()='Expand All']"));
			js.executeScript("arguments[0].scrollIntoView(false);", expall);
			expall.click();
			
			driver.findElement(By.xpath("//span[text()='This is the First Topic']")).click();
			
			try {
				driver.findElement(By.xpath("//input[text()='Mark Complete']")).click();
				System.out.println("Complted the Course");
				}
			catch(Exception e) {
				System.out.println("The course is already completed");
			}
		
		}
		catch(Exception e) {
			System.out.println("Error:" + e.getMessage());
			System.out.println("Test Case got Failed");
		}
		
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}


}
