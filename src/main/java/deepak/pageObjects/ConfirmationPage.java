package deepak.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import deepak.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	
	By confirmBy=By.cssSelector("[class='hero-primary']");
	
	@FindBy(css="[class='hero-primary']")
	WebElement confirmation;
	
	public String GetOrderConfirmation()
	{
		waitForElementToAppear(confirmBy);
	    return confirmation.getText();
		
	}
	
	

	
	

}
