package deepak.tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import deepak.TestComponents.BaseTest;
import deepak.pageObjects.CartPage;
import deepak.pageObjects.ConfirmationPage;
import deepak.pageObjects.HomePage;
import deepak.pageObjects.OrderPage;

public class ErrorValidationTest extends BaseTest {
	
	@Test
	public void loginErrorValidation()
	{
		loginpage.goToLogin("deepak121@gmail.com","Deepak@12");
		String toaster = loginpage.getToasterMsg();
		Assert.assertEquals(toaster, "Incorrect email or password");
	}

	@Test
	public void ProductErrorValidation() throws IOException
	{
	
		
		HomePage homepage = loginpage.goToLogin("deepak121@gmail.com","Deepak@123");
		
		homepage.AddProductToCart();
		CartPage cartpage = homepage.goToCart();
		Assert.assertEquals(cartpage.verifyProductName(), "ZARA COAT 334");  
		

	}
	
}
