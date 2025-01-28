package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormFilling {
@Test(dataProvider= "testData")
public void fill(String name, String pass, String email, String url, String digi, String num, String alpha)
{
	System.setProperty("webdriver.gecko.driver","./Browsers/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://demoapps.qspiders.com/ui/formValidation?sublist=0");
	driver.findElement(By.name("requiredfield")).sendKeys(name);
	driver.findElement(By.name("password")).sendKeys(pass);
	driver.findElement(By.name("confirmpass")).sendKeys(pass);
	driver.findElement(By.name("email")).sendKeys(email);
	driver.findElement(By.name("url")).sendKeys(url);
	driver.findElement(By.name("digits")).sendKeys(url);
	driver.findElement(By.name("number")).sendKeys(num);
	driver.findElement(By.name("alphanum")).sendKeys(alpha);
}
@DataProvider(name="testData")
public Object[][] createData()
{
	return new Object[][]
			{
		{"sinchan","suma@123","sinchan@gmail.com","www.sinchan.com", "2289", "123891", "sih329n"},
		{"suma","seema@123", "suma@gmail.com", "www.suma.com", "47920", "102831029", "syhdn20398"},
		{"Thanish", "Thanish@123", "thanish@gmail.com","wwww.thanish.com", "12937", "3891708","fdj238un"},
			};
}}
