package deepak.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import deepak.AbstractComponents.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent {
	
	WebDriver driver;
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productnames;
	
	
	public boolean VerifyOrderDisplayinHistory(String productname)
	{
		boolean match = productnames.stream().anyMatch(cartproduct->cartproduct.getText().equals(productname));
		return match;
	}

}
