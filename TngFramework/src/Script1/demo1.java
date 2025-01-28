package Script1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class demo1 {
	@Test
	public void disp() 
	{
		System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
		   WebDriver driver=new FirefoxDriver();
		   driver.get("https://www.redbus.in/");
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//span[text()='Date']")).click();
		   driver.findElement(By.xpath("//span[text()='28']")).click();
		
	}
	  
}
