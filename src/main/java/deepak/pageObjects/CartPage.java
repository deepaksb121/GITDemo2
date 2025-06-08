package deepak.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import deepak.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By checkoutby=By.xpath("//div //li[3]/button");
	@FindBy(xpath="//div //li[3]/button")
	WebElement checkout;
	
	@FindBy(css="div[class='cartSection'] h3")
	WebElement productName;
	
	
	public OrderPage goToCheckout()
	{
		waitForElementToAppear(checkoutby);
		checkout.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
		
	}
	
	public String verifyProductName()
	{
		return productName.getText();
	}

}
