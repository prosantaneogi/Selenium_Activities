		/*		7. Count the number of courses
		Goal: Navigate to the “All Courses” page and count the number of courses.
		a. Open a browser.
		b. Navigate to ‘https://alchemy.hguy.co/lms’.
		c. Find the navigation bar.
		d. Select the menu item that says “All Courses” and click it.
		e. Find all the courses on the page.
		f. Print the number of courses on the page.
		*/
package testNGSeleniumProjectAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CounttheNumberofCoursesinAllCourses_Act7 {
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
	
	@Test
	public void CountNumberofCourses() throws InterruptedException {
		
		try {
			WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Courses")));
			elem.click();
			
			List<WebElement> courses = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']/div"));
			int noofcourses = courses.size();
			
			System.out.println("Total number of courses is : " + noofcourses);
			for(int i = 0 ; i < noofcourses ; i++) {
				System.out.println("****************************");
				System.out.println("The course "+(i+1)+ " is :" + courses.get(i).getText());
				System.out.println("****************************");
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
