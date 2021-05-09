package makeMyTrip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;



public class Ufix {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://ufix.att.com/portal/index.html");
		
		
		
		//Thread.sleep(100000);
		
		WebDriverWait w=new WebDriverWait(driver,200);
		w.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@class='btn btn-primary btn-continue']"))));
		driver.findElement(By.xpath("//input[@class='btn btn-primary btn-continue']")).click();
		
		System.out.println("chl gya kya");
		
		
		
		
//		String handle = driver.getWindowHandle();
//		
//		driver.switchTo().window(handle);
//				System.out.println("window----->"+handle);
//				
//				//driver.switchTo().alert().accept();
//				WebElement webl=driver.findElement(By.xpath("//div[@class='modal-content-inner modal-desktop-large']//input[@value='Continue']"));
//				
//				System.out.println("Step1");
//				new Actions(driver).click(webl).perform();
//				System.out.println("Step2");
//	JavascriptExecutor js=(JavascriptExecutor) driver;
//	System.out.println("Step3");
//	js.executeScript("arguments[0].click();", webl);
//	System.out.println("Step4");
				//driver.findElement(By.xpath("//div[@class='modal-content-inner modal-desktop-large']//input[@value='Continue']")).click();
		

		
//	Set<String> id=driver.getWindowHandles();
//		
//		Iterator<String> it=id.iterator();
//		
//		System.out.println("parentId "+it.next());
//		System.out.println("childId "+it.next());
	
//		
//		
//		
//		WebElement popDriver=driver.findElement(By.xpath("//div[@class='modal-content-inner modal-desktop-large']"));
//		System.out.println("first step");
//		driver.switchTo().frame(popDriver);
//		System.out.println("second step");
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		System.out.println("third step");
//	}
	}
}
