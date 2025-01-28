package com.comcast.crm.contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.objectRepository.ContactsPage;
import com.comcast.objectRepository.CreateNewContactsPage;
import com.comcast.objectRepository.HomePage;
import com.comcast.objectRepository.LoginPage;

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileUtility fLib=new FileUtility();
		ExcelUtility exLib=new ExcelUtility();		
		JavaUtility jLib=new JavaUtility();
		WebdriverUtility wbU=new WebdriverUtility();
		
		String bro = fLib.getDataFromPropertiesFile("Browser");
		String url = fLib.getDataFromPropertiesFile("URL");
		 String UN = fLib.getDataFromPropertiesFile("Username");
		 String pwd = fLib.getDataFromPropertiesFile("Password");
		
		String LastName=exLib.getDataFromExcel("ContactTestCase", 4, 2) + jLib.getRandomNumber();
		
		//String Mobile=ro.getCell(3).toString();
		//String Type = ro.getCell(5).toString();
		
		 WebDriver driver = null;
		if(bro.equals("chrome")) {
			driver=new ChromeDriver();
				}
		if(bro.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.get(url);
		wbU.maximizeWindow(driver);
		wbU.waitForPageToLoad(driver);
			
		String startDate=jLib.getSystemDateYYYYMMDD();
		String endDate=jLib.getRequiredDateYYYYMMDD(30);
					
		//Login and create contact	
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApp(UN, pwd);
		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getIcon().click();
		
		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		cnp.getLastNameEdit().sendKeys(LastName);
		
		
		//enter start date and end date
		cnp.getStartDate().clear();
        cnp.getStartDate().sendKeys(startDate);
        Thread.sleep(2000);
        cnp.getEndDate().clear();
        //cnp.getEndDate().sendKeys(Keys.BACK_SPACE);
		cnp.getEndDate().sendKeys(endDate);
		cnp.getSave().click();
		
		//verify header msg orgname info
	 
		String actualStart= driver.findElement(By.id("mouseArea_Support Start Date")).getText();
		if(actualStart.contains(startDate))
		{
			System.out.println(LastName +" information is verified===PASS");
		
		}
		else
			System.out.println(LastName +" information is verified===FAIL");
		
		//verify header name info as expected result
		String actualEnd = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if(actualEnd.contains(endDate))
		{			System.out.println(LastName + "information is verified===PASS");		
		}
		else
			System.out.println(LastName + " information is verified===FAIL");
}}
