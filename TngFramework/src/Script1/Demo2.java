package Script1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo2 {
@Test
public void disp1()
{
	System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
	   WebDriver driver=new FirefoxDriver();
	driver.get("https://demoapps.qspiders.com/ui/alert?sublist=0");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   driver.findElement(By.id("buttonAlert2")).click();
	   Alert a = driver.switchTo().alert();
	   a.accept();
	   driver.findElement(By.xpath("//a[text()='Prompt']")).click();
	   driver.findElement(By.xpath("//button[text()='Prompt Alert Box']")).click();
	   a.sendKeys("Yes");
	   a.accept();	
}
}
