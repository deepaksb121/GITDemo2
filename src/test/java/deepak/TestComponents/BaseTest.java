package deepak.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import deepak.pageObjects.LoginPage;

public class BaseTest {
	
	
	 public WebDriver driver;
	 public LoginPage loginpage;
	
	public  WebDriver InitializeDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//deepak//Resources//Global.properties");
		prop.load(fis);
		String browsername =System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
	//	String browsername = prop.getProperty("browser");
		
		if(browsername.contains("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browsername.contains("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		return driver;
	}
	
	@BeforeMethod
	public LoginPage LaunchApplication() throws IOException
	{
		driver=InitializeDriver();
		loginpage=new LoginPage(driver);
		loginpage.goToURL();
		return loginpage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	public String getScreenShot(String TestcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//Reports"+TestcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//Reports"+TestcaseName+".png";
	}


}

