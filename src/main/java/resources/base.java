package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties pr;
	public FileInputStream fis;
	public WebDriver intializeDriver() throws IOException
	{
	 pr=new Properties();
	fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		 pr.load(fis);
		 
	    String browserName= pr.getProperty("browser");
	    
		if (browserName.equalsIgnoreCase("chrome")) {
			//chrome
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		  this.driver=new ChromeDriver();
		  	
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//firfox
			
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"/Drivers/geckodriver");
		   this.driver=new FirefoxDriver();
		}

		
	
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public void getScreenshot(String result) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"/Screenshots/"+result+".png"));
		
	}

}
