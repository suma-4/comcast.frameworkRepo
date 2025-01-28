package Runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import POM.FbLogin;

public class RunFB {
@Test
public void Fb()
{
	System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	FbLogin log=new FbLogin(driver);
	log.userName("Sinchan");
	log.password("suma@123");
	log.login();
}
}
