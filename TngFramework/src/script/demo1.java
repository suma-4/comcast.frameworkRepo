package script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class demo1 {

	@Test
	public void test1() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in");
		Thread.sleep(3000);
		List<WebElement> box = driver.findElements(By.xpath("//a"));
	    for(  WebElement we:box)
	    {
	    	Reporter.log(we.getAttribute("href"));
	}
}}
