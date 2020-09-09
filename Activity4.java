package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {

	@Test
	public void FirstTest() {
		System.out.println("This is to check suite xml FirstTest");
	}
	@Test
	public void SecondTest() {
		System.out.println("This is to check suite xml SecondTest ");
	}
}
