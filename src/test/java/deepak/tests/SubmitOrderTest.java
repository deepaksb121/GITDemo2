package deepak.tests;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import deepak.TestComponents.BaseTest;
import deepak.pageObjects.CartPage;
import deepak.pageObjects.ConfirmationPage;
import deepak.pageObjects.HomePage;
import deepak.pageObjects.LoginPage;
import deepak.pageObjects.OrderHistoryPage;
import deepak.pageObjects.OrderPage;

public class SubmitOrderTest extends BaseTest {

	String productname="ZARA COAT 3";
	
	@Test(dataProvider= "getData")
	public void ConfirmOrdertest(HashMap<String,String> input) throws IOException
	{
	
		
		HomePage homepage = loginpage.goToLogin(input.get("username"),input.get("password"));
		
		homepage.AddProductToCart();
		CartPage cartpage = homepage.goToCart();
		
		OrderPage orderpage = cartpage.goToCheckout();
		
		orderpage.CountrySelection();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		ConfirmationPage confirm = orderpage.PlaceOrder();
		
		String msg = confirm.GetOrderConfirmation();
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
		

	}
	
	@Test
	public void VerifyOrderHistory() throws IOException
	{
	
		
		HomePage homepage = loginpage.goToLogin("deepak121@gmail.com","Deepak@123");
		
		homepage.AddProductToCart();
		OrderHistoryPage orderhistory = homepage.goToOrders();
		Assert.assertTrue(orderhistory.VerifyOrderDisplayinHistory("ZARA COAT 3"));
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String, String> map=new HashMap<String,String>();
		map.put("username", "deepak121@gmail.com");
		map.put("password", "Deepak@123");
		
		HashMap<String, String> map1=new HashMap<String,String>();
		map1.put("username", "deepak121@gmail.com");
		map1.put("password", "Deepak@123");
		
		return new Object[][] { {map},{map1} };
		
	}
	

}
