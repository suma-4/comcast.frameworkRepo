package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Generic {
	public WebDriver driver;
@BeforeClass
public void launch()
{
	System.setProperty("webdriver.gecko.driver","./Browsers/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://106.51.87.42:9007/");
}
@BeforeMethod
public void login()
{
  	driver.findElement(By.id("email")).sendKeys("kumaranna@gmail.com");
  	driver.findElement(By.id("password")).sendKeys("123456");
   driver.findElement(By.xpath("//button[text()='button']")).click();
}
}
