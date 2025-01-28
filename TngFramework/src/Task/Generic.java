package Task;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import script.GenericSC;

public class Generic extends GenericSC {
 WebDriver driver;
@BeforeClass
public void vait()
{
	System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

@BeforeMethod
public void action()
{
	driver.findElement(By.id("email")).sendKeys("sinchan.suma@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("Thanish@123");
	driver.findElement(By.name("login")).click();
}
@AfterMethod
public void photo() throws IOException
{ 
	getPhoto(driver);
	
}
@AfterClass
public void out()
{
	driver.close();
	}	}
