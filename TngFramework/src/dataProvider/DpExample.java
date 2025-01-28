package dataProvider;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DpExample {
	@Test(dataProvider ="testData")
	public void launch(String un, String pwd)
	{
	System.setProperty("webdriver.gecko.driver","./Browsers/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
	driver.findElement(By.id("email")).sendKeys(un);
	driver.findElement(By.id("pass")).sendKeys(pwd);
	driver.findElement(By.name("login")).click();
	driver.close();
	}
	@DataProvider(name="testData")
	public Object[][] createData()
	{
		return new Object[][]
				{
			{"sinchan","suma@123"},
			{"suma","seema@123"},
			{"Thanish", "Thanish@123"},
				};
	}
}
