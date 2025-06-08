package deepak.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import deepak.pageObjects.CartPage;
import deepak.pageObjects.OrderHistoryPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement orders;
	

	public void waitForElementToAppear(By findby)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	
	public void waitForWebElementToAppear(WebElement toasterEle)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(toasterEle));
		
	}
	
	public void waitForElementToDisappear(By findby)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOfElementLocated(findby));
		
	}
	
	public CartPage goToCart()
	{
		cart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	
	public OrderHistoryPage goToOrders()
	{
		orders.click();
		OrderHistoryPage orderhistory=new OrderHistoryPage(driver);
		return orderhistory;
	}

}
