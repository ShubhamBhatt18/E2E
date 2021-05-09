package Academy.E2EProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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


public class HomePage extends base {

public static Logger log=LogManager.getLogger(HomePage.class.getName());
	
	@Test(dataProvider="getData")
	public void basePackageNavigation(String email,String pass) throws IOException {
		
		
		driver=intializeDriver();
		log.info("Intialized the driver");
		
		driver.get("http://qaclickacademy.com");
		
		log.info("navigated to entered url");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		LandingPage land=new LandingPage(driver);
		
//		WebDriverWait wait=new WebDriverWait(driver,40);
//		wait.until(ExpectedConditions.elementToBeClickable(land.noThanks()));
//		
//		land.noThanks().click();
		
		//Assert.assertEquals(land.getTextFeature().getText(),"Featured Courses");
		 
		
		
		
		
		if(land.noThanksButton().getText().equalsIgnoreCase("NO THANKS")) {
			land.noThanksButton().click();
			
			log.debug("no thanks button is clicked");
			land.getLogin().click();
			LoginPage login =new LoginPage(driver);
			login.Email().sendKeys(email);
			login.Password().sendKeys(pass);
			login.LoginButton().click();
			
			Assert.assertTrue(login.LoginButton().isDisplayed());
			log.error("I will get an error");
		}
		else {
			land.getLogin().click();
			LoginPage login =new LoginPage(driver);
			login.Email().sendKeys(email);
			login.Password().sendKeys(pass);
			login.LoginButton().click();
		}
		
		
		
		
	}
	
	 @AfterTest
	public void closeBrower() {
		driver.close();
		
		driver=null;
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][2];
		
		data[0][0]="abc@qw";
		data[0][1]="1234";
		data[1][0]="xyz@c.com";
		data[1][1]="3456";
		
		return data;
	}
	

	
}
