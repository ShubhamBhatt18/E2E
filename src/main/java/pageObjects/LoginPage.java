package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(css="input[id='user_password']")
	WebElement password;
	
	@FindBy(css="input[value='Log In']")
	WebElement login;
	
	public WebElement Email() {
		return email;
	}
	
	public WebElement Password() {
		return password;
	}
	
	public WebElement LoginButton() {
		return login;
	}
}
