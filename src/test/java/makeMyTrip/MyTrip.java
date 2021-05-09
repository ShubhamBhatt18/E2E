package makeMyTrip;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MyTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String item;

		List<WebElement> month;

		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//li[contains(text(),'Round Trip')]")).click();

		System.out.println("it clicked");

		driver.findElement(By.id("fromCity")).click();

		WebElement fromDrop = driver.findElement(By.xpath("//input[@placeholder='From']"));
		fromDrop.sendKeys("Pun");
		Thread.sleep(2000);
		fromDrop.sendKeys(Keys.ARROW_DOWN);

		String script;
		String text;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		text = (String) js.executeScript("return arguments[0].value;", fromDrop);
		System.out.println(text);
		int r = 0;
		while (r <= 5) {
			if (text.equalsIgnoreCase("Pune")) {
				fromDrop.sendKeys(Keys.ENTER);

				break;
			} else {
				fromDrop.sendKeys(Keys.ARROW_DOWN);
				text = (String) js.executeScript("return arguments[0].value;", fromDrop);
				System.out.println(text);

				r++;
			}

		}

		// RETURN CITY

		WebElement toDrop = driver.findElement(By.xpath("//input[@placeholder='To']"));
		toDrop.sendKeys("Hyd");
         Thread.sleep(2000);
		toDrop.sendKeys(Keys.ARROW_DOWN);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		text = (String) js1.executeScript("return arguments[0].value;", toDrop);
		System.out.println(text);
		int r1 = 0;
		while (r1 <= 5) {
			if (text.equalsIgnoreCase("Hyderabad")) {
				toDrop.sendKeys(Keys.ENTER);

				break;
			} else {
				toDrop.sendKeys(Keys.ARROW_DOWN);
				text = (String) js1.executeScript("return arguments[0].value;", toDrop);
				System.out.println(text);

				r1++;
			}

		}

		
		//SELECT DATES
		
		List<WebElement> dates = driver.findElements(By.xpath(
				"//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[@class='DayPicker-Day']"));
		for (int i = 0; i < dates.size(); i++) {

			System.out.println(dates.get(i).getText());
			String date = dates.get(i).getText();
			if (date.equalsIgnoreCase("18")) {
				driver.findElements(By.xpath(
						"//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[@class='DayPicker-Day']"))
						.get(i).sendKeys(Keys.ENTER);
				;

				System.out.println("element clicked");
				break;
			}

		}

		// RETURN DATES

		month = driver.findElements(By.xpath("//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']"));
		List<String> stringMonth = new ArrayList<String>();

		for (int i = 0; i < month.size(); i++) {

			System.out.println(stringMonth.add(month.get(i).getText()));

		}

		while (stringMonth.size() != 0) {

			if (stringMonth.contains("July2020")) {

				// returm date xpath is customized as per month position ,its hardcoded,need to
				// be more dynamic
				List<WebElement> returndates = driver.findElements(By.xpath(
						"//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[@class='DayPicker-Day']"));

				for (int j = 0; j < returndates.size(); j++) {

					String rDate = returndates.get(j).getText();
					System.out.println(rDate);
					if (rDate.equalsIgnoreCase("20")) {
						returndates.get(j).sendKeys(Keys.ENTER);
						break;
					} else {
						continue;
					}
				}
				break;
			} else {

				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				System.out.println("arrow clicked");
				Thread.sleep(2000);
				month = driver
						.findElements(By.xpath("//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']"));
				for (int i = 0; i < month.size(); i++) {

					stringMonth.add(month.get(i).getText());
				}

			}

		}
		
		
		// click on search button
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();

		Thread.sleep(4000);
		
		/* ############ SECOND PAGE ##################### */

		// click 2nd row flight departure radio button
		driver.findElement(By.xpath(
				"//div[@class='splitVw-sctn pull-left']/div/div[2]/label/div[1]/span[1]")).click();
		
		System.out.println("left radio button got clicked");

		// click 2nd row radio button return flight
		driver.findElement(By.xpath(
				"//div[@class='splitVw-sctn pull-right']/div/div[2]/label/div[1]/span[1]")).click();
        
		System.out.println("Right radio button got clicked");
		// click button book now
		driver.findElement(By.xpath("//button[@class='fli_primary_btn text-uppercase ']")).click();
		System.out.println("Book now button clicked");

		
		//Clicked continue button
		driver.findElement(By.xpath("//button[@class='btn fli_primary_btn ']")).click();
		System.out.println("continue button clicked");
		
		System.out.println("Title of current window "+driver.getTitle());
		
		//Get all windows id
		Set<String> ids=driver.getWindowHandles();
		
		Iterator<String> it=ids.iterator();
		
		String parentid=it.next();
		String childid=it.next();
		
		System.out.println("PArent_id "+parentid);
		System.out.println("Child_id "+childid);
		
		//switched to second child window
		driver.switchTo().window(childid);
		System.out.println("Child window switched");
		
		//REVIEW YOUR BOOKING PAGE
		
		Thread.sleep(2000);
		//clicked on No radio under Add-Ons
		driver.findElement(By.xpath("//div[@class='make_relative']//label[@class='block radio']//input[@value='no']")).click();
		System.out.println("No radio button clicked");
		
		Thread.sleep(2000);
		
		//clicked on continue button at review your booking page
		 driver.findElement(By.xpath("//button[@id='review-continue']")).click();
		 System.out.println("review continue button clicked");

		 
		 /*############### TRAVELLER & ADDONS #################*/
		 
		 Thread.sleep(2000);
		 
		 // click on ADD ADULT
		 driver.findElement(By.xpath("//a[contains(text(),'+ ADD ADULT')]")).click();
		 
		 driver.findElement(By.xpath("//input[@placeholder='First & Middle Name']")).sendKeys("Leonard");
		 driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Flakes");
		 driver.findElement(By.xpath("//div[@class='chooseGender-info  GENDER ']/label[1]")).click();
		 
		 System.out.println("Adult added");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//input[@placeholder='Mobile No']")).sendKeys("9720947694");
		 driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shubhambhatt18@hotmail.com");
		 
		 System.out.println("contact info given");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//button[@class='ack-cta btn fli_primary_btn text-uppercase']")).click();
		 System.out.println("acknowledgement button clicked");
		 
		 
		 //TRAVELLERS AND ADDONs
		 
		 driver.findElement(By.xpath("//a[@id='ancillary-continue']")).click();
		 System.out.println("next button clicked at TRAVELLERS AND ADDONs");
		 
		 //Click CONTINUE ANYWAY
		 driver.findElement(By.xpath("//a[@class='btn fli_secondry_btn text-uppercase']")).click();
		 System.out.println("Clicked Click CONTINUE ANYWAY");
		 
		 
		 
		
		
	}

}
