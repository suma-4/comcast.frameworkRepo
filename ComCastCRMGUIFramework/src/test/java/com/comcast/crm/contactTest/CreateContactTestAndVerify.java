package com.comcast.crm.contactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.objectRepository.ContactInformationPage;
import com.comcast.objectRepository.ContactsPage;
import com.comcast.objectRepository.CreateNewContactsPage;
import com.comcast.objectRepository.HomePage;
import com.comcast.objectRepository.LoginPage;

public class CreateContactTestAndVerify {

	public static void main(String[] args) throws IOException {
		
		FileUtility fLib=new FileUtility();
		ExcelUtility exLib=new ExcelUtility();		
		JavaUtility jLib=new JavaUtility();
				
		String bro = fLib.getDataFromPropertiesFile("Browser");
		String url = fLib.getDataFromPropertiesFile("URL");
		 String UN = fLib.getDataFromPropertiesFile("Username");
		 String pwd = fLib.getDataFromPropertiesFile("Password");
		
		String LastName = exLib.getDataFromExcel("ContactTestCase", 1, 2) + jLib.getRandomNumber();
		String Mobile = exLib.getDataFromExcel("ContactTestCase", 1, 3);
				
		 WebDriver driver;
		if(bro.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
			driver=new ChromeDriver();
		
		driver.get(url);
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApp(UN, pwd);
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getIcon().click();
		
		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		cnp.getLastNameEdit().sendKeys(LastName);
		cnp.getNumberEdit().sendKeys(Mobile);
		cnp.getSave().click();
		
			
		//verify header msg orgname info
		ContactInformationPage cip=new ContactInformationPage(driver);
		String header=cip.getHeaderText().getText();
		 
		if(header.contains(LastName))
		{
			System.out.println("Testcase is PASS");
		}
		else
			System.out.println("Testcase is FAIL");
		
		//verify header name info as expected result
		String headerName=cip.getHeaderText1().getText();
		
		 	if(headerName.contains(Mobile))
		{
			System.out.println("Header infor is visible====PASS");
			
		}
		else
	
		System.out.println("Header infor is not visible====FAIL");
		 	
		 	hp.signOut(driver);
}
	
	}
