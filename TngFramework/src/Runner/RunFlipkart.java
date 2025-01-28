package Runner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import POM.Flipkart;

public class RunFlipkart {
	WebDriver driver;
@Test
public void disp() {
System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
driver=new FirefoxDriver();
driver.manage().window().maximize();
driver.get("https://www.flipkart.com/");
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
Flipkart buy=new Flipkart(driver);
buy.search();
buy.pic();
String bro=driver.getWindowHandle();
 Set<String> allbro = driver.getWindowHandles();
 allbro.remove(bro);
 for(String browse:allbro)
 {
	 driver.switchTo().window(browse);
 }
 buy.buyNow();

}}
