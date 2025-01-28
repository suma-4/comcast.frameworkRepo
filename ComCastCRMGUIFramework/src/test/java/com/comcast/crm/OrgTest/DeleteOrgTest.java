package com.comcast.crm.OrgTest;

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
import com.comcast.objectRepository.CreateNewOrgPage;
import com.comcast.objectRepository.HomePage;
import com.comcast.objectRepository.LoginPage;
import com.comcast.objectRepository.OrgInformationPage;
import com.comcast.objectRepository.OrganizationPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileUtility fLib=new FileUtility();
		ExcelUtility exLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebdriverUtility wbU=new WebdriverUtility();
		
				//read data from properties file
				String bro = fLib.getDataFromPropertiesFile("Browser");
				String url = fLib.getDataFromPropertiesFile("URL");
				 String UN = fLib.getDataFromPropertiesFile("Username");
				 String pwd = fLib.getDataFromPropertiesFile("Password");
				 
				//read data from excel
				 String orgName=exLib.getDataFromExcel("OrgTestCase", 2, 2) + jLib.getRandomNumber();
				
				 //launch the browser
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
				
				//perform action on elements
				
				LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
				lp.getUsernameEdit().sendKeys(UN);
				lp.getPasswordEdit().sendKeys(pwd);
				lp.getLoginbtn().click();
				
				//lp.loginToApp("admin", "admin");
				
				HomePage hp = new HomePage(driver);
				hp.getOrgLink().click();
				
				OrganizationPage op = new OrganizationPage(driver);
				op.getIcon().click();
				
				CreateNewOrgPage cop=new CreateNewOrgPage(driver);
				cop.getOrgName().sendKeys(orgName);
				cop.getSave().click();
				
				//verify header msg orgname info
				OrgInformationPage oip=new OrgInformationPage(driver);
				String headerText=oip.getHeaderMsg().getText();
				
				if(headerText.contains(orgName))
				{
					System.out.println("Testcase is PASS");
				
				}
				else
					System.out.println("Testcase is FAIL");
				
				//verify header name info as expected result
				String headerName = oip.getHeaderName().getText();
				 
				if(headerName.contains(orgName))
				{
					System.out.println("Header infor is visible====PASS");
					
				}
				else
					System.out.println("Header infor is not visible====FAIL");
				
				
				hp.getOrgLink().click();
				op.getSearchText().sendKeys(orgName);
				wbU.handleDropdownByVisibleText(op.getSearchBy(), "Organization Name");
				op.getSearchbtn().click();
				driver.findElement(By.xpath("//a[.='"+orgName+"']/../../td[8]/a[.='del']")).click();
				wbU.switchToAlertAndAccept(driver);
				Thread.sleep(2000);
				hp.signOut(driver);
	}


}
