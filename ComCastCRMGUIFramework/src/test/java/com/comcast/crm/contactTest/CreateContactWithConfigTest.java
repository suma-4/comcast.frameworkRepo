package com.comcast.crm.contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTestUtility.BaseUtilityClass;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.objectRepository.ContactInformationPage;
import com.comcast.objectRepository.ContactsPage;
import com.comcast.objectRepository.CreateNewContactsPage;
import com.comcast.objectRepository.HomePage;

public class CreateContactWithConfigTest extends BaseUtilityClass{

	JavaUtility jLib=new JavaUtility();
	@Test(groups = {"SmokeTest"} )
	public void createContactTest() throws EncryptedDocumentException, IOException
	{
		String LastName = eLib.getDataFromExcel("ContactTestCase", 3, 5) + jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getIcon().click();

		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		cnp.getLastNameEdit().sendKeys(LastName);
		cnp.getSave().click();
		
		ContactInformationPage cip=new ContactInformationPage(driver);
		String header=cip.getHeaderText().getText();
		 
		if(header.contains(LastName))
		{
			System.out.println("Testcase is PASS");
		}
		else
			System.out.println("Testcase is FAIL");
		
	}
	
	@Test(groups = {"RegressionTest"})
	public void createContactWithPhoneNO() throws EncryptedDocumentException, IOException
	{
		String LastName = eLib.getDataFromExcel("ContactTestCase", 1, 2) + jLib.getRandomNumber();
		String Mobile = eLib.getDataFromExcel("ContactTestCase", 1, 3);
		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getIcon().click();

		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		cnp.getLastNameEdit().sendKeys(LastName);
		cnp.getNumberEdit().sendKeys(Mobile);
		cnp.getSave().click();
		
		ContactInformationPage cip=new ContactInformationPage(driver);
		String header=cip.getHeaderText().getText();
		boolean info=header.contains(LastName);
		Assert.assertEquals(info, true);
		System.out.println(info);
		
		String phone = cip.getMobile().getText();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(phone, Mobile);
			
	}
}
