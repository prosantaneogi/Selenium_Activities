/*		3. Verify the title of the first info box
		Goal: Read the title of the first info box on the website and verify the text
		a. Open a browser.
		b. Navigate to ‘https://alchemy.hguy.co/lms’.
		c. Get the title of the first info box.
		d. Make sure it matches “Actionable Training” exactly.
		e. If it matches, close the browser.*/

package testNGSeleniumProjectAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class VerifytheTitleoftheFirstInfobox_Act3 {
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
	public void VerifytheTitleoftheFirstInfobox() {
		
		
		//WebElement firstbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uagb-columns__inner-wrap uagb-columns__columns-3']/div[1]")));
		
		  List<WebElement> elements = driver.findElements(By.cssSelector("h3.uagb-ifb-title"));
				  
		  WebElement firstbox = elements.get(0);
		  //WebElement stbox = elements.get(1);
		  //WebElement thirdbox = elements.get(2);
		  String headingoftheFirstInfobox = firstbox.getText();
		  System.out.println("The title of the page for Verifythewebsitetitle activity is :" + headingoftheFirstInfobox);
		  Reporter.log("Repoter Log"+headingoftheFirstInfobox , true);
		try {
			Assert.assertEquals(headingoftheFirstInfobox, "Actionable Training");
			Reporter.log("Expected header found" , true);
			driver.close();
		}
		catch(Exception e) {
			System.out.println("Expected header not found");
		}


	}


}
