package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net");
  }
  @Test
  public void Testfunc() {
	  
	  String pagetitle = driver.getTitle();

	  System.out.println("The title of the page "+pagetitle);
	  
	  Assert.assertEquals("Training Support",pagetitle);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  
	  WebElement linksam = wait.until(ExpectedConditions.visibilityOfElementLocated(By.ByXPath.id("about-link")));
	  
	  linksam.click();
	  
	  String newpageTitle = driver.getTitle();
	  
      System.out.println("The New title of the page "+newpageTitle);
	  
	  Assert.assertEquals("About Training Support",newpageTitle);
  }
 

  @AfterMethod
  public void afterMethod() {
  //Closing the browser
	  driver.quit();
	  
  }

}
