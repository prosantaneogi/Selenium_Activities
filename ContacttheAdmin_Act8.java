		/*		8. Contact the admin
				Goal: Navigate to the “Contact Us” page and complete the form.
				a. Open a browser.
				b. Navigate to ‘https://alchemy.hguy.co/lms’.
				c. Find the navigation bar.
				d. Select the menu item that says “Contact” and click it.
				e. Find the contact form fields (Full Name, email, etc.)
				f. Fill in the information and leave a message.
				g. Click submit.
				h. Read and print the message displayed after submission.
				i. Close the browser.
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


public class ContacttheAdmin_Act8 {
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

	@Test
	public void CountNumberofCourses() throws InterruptedException {

		try {
			WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact")));
			elem.click();
			Thread.sleep(5000);
			WebElement FullName = driver.findElement(By.xpath("//div[@class='wpforms-field-container']/div[1]/input"));
			js.executeScript("arguments[0].scrollIntoView(true);", FullName);
			FullName.sendKeys("Prosanta Neogi");

			WebElement Email = driver.findElement(By.xpath("//div[@class='wpforms-field-container']/div[2]/input"));
			Email.sendKeys("pro@abc.com");

			WebElement Subject = driver.findElement(By.xpath("//div[@class='wpforms-field-container']/div[3]/input"));
			WebElement Message = driver.findElement(By.xpath("//div[@class='wpforms-field-container']/div[4]/textarea"));
			WebElement submitbtn = driver.findElement(By.xpath("//button[text()='Send Message']"));

			Subject.sendKeys("Subject of the Message");
			Message.sendKeys("Test Message for LMS Project");
			submitbtn.click();

			WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wpforms-confirmation-container wpforms-confirmation-scroll']/p")));
			//driver.findElement(By.xpath("//div[@class='wpforms-confirmation-container wpforms-confirmation-scroll']/p"));
			System.out.println("Message displayed after submission : " + msg.getText());

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
