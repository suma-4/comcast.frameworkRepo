package com.comcast.crm.contactTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.objectRepository.ContactInformationPage;
import com.comcast.objectRepository.ContactsPage;
import com.comcast.objectRepository.CreateNewContactsPage;
import com.comcast.objectRepository.CreateNewOrgPage;
import com.comcast.objectRepository.HomePage;
import com.comcast.objectRepository.LoginPage;
import com.comcast.objectRepository.OrgInformationPage;
import com.comcast.objectRepository.OrganizationPage;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException {
		
		FileUtility fLib=new FileUtility();
		ExcelUtility exLib=new ExcelUtility();		
		JavaUtility jLib=new JavaUtility();
		WebdriverUtility wbU=new WebdriverUtility();
		
		String bro = fLib.getDataFromPropertiesFile("Browser");
		String url = fLib.getDataFromPropertiesFile("URL");
		 String UN = fLib.getDataFromPropertiesFile("Username");
		 String pwd = fLib.getDataFromPropertiesFile("Password");
		
		String orgName = exLib.getDataFromExcel("ContactTestCase", 7, 2) + jLib.getRandomNumber();
		String LastName = exLib.getDataFromExcel("ContactTestCase", 7, 3) + jLib.getRandomNumber();
		
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
		
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApp(UN, pwd);
	
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getIcon().click();
		
		CreateNewOrgPage cop=new CreateNewOrgPage(driver);
		cop.getOrgName().sendKeys(orgName);
		cop.getSave().click();
						
		//verify header name info as expected result
		OrgInformationPage oip=new OrgInformationPage(driver);
		String headerName=oip.getHeaderMsg().getText();
		 		if(headerName.contains(orgName))
		{
			System.out.println("Header infor is visible====PASS");
			
		}
		else
			System.out.println("Header infor is not visible====FAIL");
		
		//navigate to Contact
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getIcon().click();
		
		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		
		cnp.getLastNameEdit().sendKeys(LastName);
		cnp.getLookUp().click();
		
		//switch to child browser
		wbU.swithToBrowser(driver, "Accounts&action");
		
	    cnp.getSearch().sendKeys(orgName);
		cnp.getSearchbtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//switch to parent window 
		wbU.swithToBrowser(driver, "Contacts&action");
			cnp.getSave().click();	
			//verify header msg
			
			ContactInformationPage cip=new ContactInformationPage(driver);
			String  LN=cip.getHeaderText().getText();
		
		if(LN.contains(LastName))
		{
			System.out.println("Header information is visible====PASS");
			
		}
		else
			System.out.println("Header information is not visible====FAIL");
		//verify orgname
		
		String  Org=cip.getHeaderText1().getText();
		
		if(Org.contains(orgName))
		{
			System.out.println("Header information is visible====PASS");
			
		}
		else
			System.out.println("Header information is not visible====FAIL");

		hp.signOut(driver);
	driver.close();
}}

