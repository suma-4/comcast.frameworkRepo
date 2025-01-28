package Generic;

import java.io.IOException; 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import script.GenericSC;

public class Facebook extends GenericSC {
   public WebDriver driver;
	@BeforeClass
	public void launch()
	{
		System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void browse()
	{
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void capture() throws IOException
	{ 
		getPhoto(driver);
	}
	
	@AfterClass
	public void exit()
	{
		driver.close();
	}
	}

