package deepak.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import deepak.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id='userEmail']")
	WebElement userEmail;
	
	@FindBy(css="input[id*='Password']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[contains(@class,'login-btn')]")
	WebElement userSignin;
	
	@FindBy(css="[class*='toast-error']")
	WebElement toastermsg;
	
	public HomePage goToLogin(String username, String password)
	{
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		userSignin.click();
		HomePage homepage=new HomePage(driver);
		return homepage;
	}
	
	public void goToURL()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getToasterMsg()
	{
		waitForWebElementToAppear(toastermsg);
		return toastermsg.getText();
	}

}
