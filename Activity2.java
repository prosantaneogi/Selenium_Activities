package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver ;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@Test
	public void TestMethod1() {
		String pageTitle1 = driver.getTitle();
		System.out.println("The Title of the First Page"+pageTitle1);
		Assert.assertEquals(pageTitle1 , "Target Practice");
	}
	@Test
	public void TestMethod2() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Blackbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui black button")));
		Assert.assertTrue(Blackbtn.isDisplayed());
		Assert.assertEquals(Blackbtn.getText() , "Black");
	}
	@Test (enabled=false)
	public void TestMethod3() {
		System.out.println("Skipping it");
		
	}
	@Test
	public void TestMethod4() {
		String condition ="Skip Test";

	    if(condition.equals("Skip Test")){
		throw new SkipException("Skipping - This is not ready for testing ");
	    } else {
		
	    }
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
