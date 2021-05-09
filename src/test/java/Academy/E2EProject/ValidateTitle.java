package Academy.E2EProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


 public class ValidateTitle extends base {

	public static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void intialize() throws IOException {
		driver=intializeDriver();
		driver.get(pr.getProperty("url"));
	}
	
	@Test
	public void basePackageNavigation() throws IOException {
		
		
		
		
		LandingPage land=new LandingPage(driver);
		
//		WebDriverWait wait=new WebDriverWait(driver,40);
//		wait.until(ExpectedConditions.elementToBeClickable(land.noThanks()));
//		
//		land.noThanks().click();
		
//		Assert.assertEquals(land.getTextFeature().getText(),"Featured Courses");
//		
//		Assert.assertTrue(land.getTextFeature().isDisplayed());
//		
		Assert.assertTrue(land.navigationBar().isDisplayed());
		
		log.info("Validated true");
		log.error("validated falsse");
		log.fatal("validated fatal error");
		
		
		}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
}
