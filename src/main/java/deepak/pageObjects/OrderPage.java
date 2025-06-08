package deepak.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import deepak.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
	}
	
	By countryby=By.cssSelector("input[placeholder='Select Country']");
	By inputby=By.xpath("//section/button[2]");
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement CountryInput;
	
	@FindBy(xpath="//section/button[2]")
	WebElement SelectCountry;
	
	@FindBy(css="[class*='submit']")
	WebElement placeOrder;
	
	
	
	public void CountrySelection()
	{
		waitForElementToAppear(countryby);
		Actions action=new Actions(driver);
		action.moveToElement(CountryInput).click().sendKeys("india").build().perform();
		waitForElementToAppear(inputby);
		action.moveToElement(SelectCountry).click().build().perform();
		
	}
	
	public ConfirmationPage PlaceOrder()
	{
		placeOrder.click();
		ConfirmationPage confirm=new ConfirmationPage(driver);
		return confirm;
	}
	
	
	

}
