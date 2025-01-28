package practiceDataProvider;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class AmznGetProductInfoTest extends ExcelUtility{

	ExcelUtility eLib=new ExcelUtility();
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String BrandName, String ProductName) throws Throwable
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//BrandName=eLib.getDataFromExcel("Amozon", 0, 1);
		//ProductName=eLib.getDataFromExcel("Amazon", 1, 1);
		//System.out.println(BrandName+" "+ProductName);
		//search product
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
		//capture product info
		
		String x="//span[text()='"+ProductName+"']/../../../../div[3]/div[1]/div/div[1]/div[2]/div[1]/a/span/span[2]/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();	
	}
	@DataProvider
	public Object[][] getData() throws Throwable
	
	{
		
		int rowCount=eLib.getRowCount("Amazon");
		System.out.println(rowCount);
		Object[][] objArr=new Object[rowCount][2];
		for (int i=0; i<rowCount; i++)
		{
			objArr[i][0]=eLib.getDataFromExcel("Amazon", i+1, 0);	
			objArr[i][1]=eLib.getDataFromExcel("Amazon", i+1, 1);	
						
		}
		return objArr;
	}}
