package Runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import POM.PomScript;

public class RunScript {

	@Test
	public void validData() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		PomScript p=new PomScript(driver);
		p.passData();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		p.passData();
		
	}
}
