package script;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Generic extends GenericSC {
public WebDriver driver;
	@BeforeMethod
	public void open()
	{
		System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void close() throws IOException
	{
	  getPhoto(driver);
	  driver.close();
	  
	}
}
