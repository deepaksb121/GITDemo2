package deepak.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import deepak.AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent{

	WebDriver driver;
	public HomePage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		
	}
	
	@FindBy(css="div[class*='mb-3']")
	List<WebElement> products;
	
	By productby=By.cssSelector("div[class*='mb-3']");
	By AddToCartBy=By.cssSelector("[class='card-body'] button:last-of-type");
	By spinner=By.cssSelector(".ng-animating");
	By toaster=By.cssSelector("div[role='alertdialog']");
	
	public void AddProductToCart()
	{
		waitForElementToAppear(productby);
		WebElement prod = products.stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(AddToCartBy).click();
		waitForElementToAppear(toaster);
		waitForElementToDisappear(spinner);
		
	}

	
	
}
