package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
By Signin=By.cssSelector("a[href*='sign_in']");

public WebElement getLogins() {
	return driver.findElement(Signin);
	
}
	
	@FindBy(css="a[href*='sign_in']")
	WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
	
	@FindBy(xpath="//div[@class='text-center']/h2")
	WebElement textFeature;
	
	public WebElement getTextFeature() {
		return textFeature;
	}
	
	
	@FindBy(css=".nav.navbar-nav.navbar-right")
	WebElement navBar;
	
	public WebElement navigationBar() {
		return navBar;
	}

	
	@FindBy(xpath="//div[@class='sumome-react-wysiwyg-popup-animation-group']//button[contains(text(),'NO THANKS')]")
   WebElement nothanksButton;
	
	
	public WebElement noThanksButton() {
		return nothanksButton;
	}
	
}
