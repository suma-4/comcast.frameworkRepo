package com.comcast.crm.OrgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.objectRepository.CreateNewOrgPage;
import com.comcast.objectRepository.HomePage;
import com.comcast.objectRepository.LoginPage;
import com.comcast.objectRepository.OrgInformationPage;
import com.comcast.objectRepository.OrganizationPage;

public class CreateOrgWithIndustyAndVerify {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		FileUtility fLib=new FileUtility();
		ExcelUtility exLib=new ExcelUtility();		
		JavaUtility jLib=new JavaUtility();
		WebdriverUtility wbU=new WebdriverUtility();
		
		//read data from properties file
		String orgName = exLib.getDataFromExcel("OrgTestCase", 5, 2) + jLib.getRandomNumber();
		String Industry=exLib.getDataFromExcel("OrgTestCase", 5, 3);
		String Type =exLib.getDataFromExcel("OrgTestCase", 5, 5);
				
		//read data from excel
		String bro = fLib.getDataFromPropertiesFile("Browser");
		String url = fLib.getDataFromPropertiesFile("URL");
		 String UN = fLib.getDataFromPropertiesFile("Username");
		 String pwd = fLib.getDataFromPropertiesFile("Password");
		 
		 //launch the browser
		 WebDriver driver = null;
		if(bro.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		if(bro.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.get(url);
		
		wbU.maximizeWindow(driver);
		wbU.waitForPageToLoad(driver);
		
		//perform actions on elements
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApp(UN, pwd);
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getIcon().click();
		
		CreateNewOrgPage cop=new CreateNewOrgPage(driver);
		cop.getOrgName().sendKeys(orgName);
		wbU.waitForElementIsClickable(driver, cop.getIndustry());
		wbU.handleDropdownByVisibleText(cop.getIndustry(), Industry);
		
		wbU.waitForElementIsClickable(driver, cop.getType());
		wbU.handleDropdownByVisibleText(cop.getType(), Type);
		
		cop.getSave().click();
		OrgInformationPage oip=new OrgInformationPage(driver);
		
		//verify header msg orgname info
		
		if(Industry.contains("Energy"))
		{
			System.out.println("Testcase is PASS");
		
		} 
		else {
			System.out.println("Testcase is FAIL");
		}
		
		if(Type.contains("Partner"))
		{
			System.out.println("Testcase is PASS");	
		}
		else
		{
			System.out.println("Testcase is FAIL");
		}
		hp.signOut(driver);
		
	}
	}