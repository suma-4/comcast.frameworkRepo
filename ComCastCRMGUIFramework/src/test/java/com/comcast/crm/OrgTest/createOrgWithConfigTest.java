package com.comcast.crm.OrgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTestUtility.BaseUtilityClass;
import com.comcast.crm.ListenerUtility.ListenerImpClass;
import com.comcast.crm.generic.webdriverUtility.UtilityClassObject;
import com.comcast.objectRepository.CreateNewOrgPage;
import com.comcast.objectRepository.HomePage;
import com.comcast.objectRepository.OrgInformationPage;
import com.comcast.objectRepository.OrganizationPage;

import junit.framework.Assert;
 
@Listeners(com.comcast.crm.ListenerUtility.ListenerImpClass.class)
public class createOrgWithConfigTest extends BaseUtilityClass {

	@Test(groups = {"SmokeTest"} )
	public void createOrgTest() throws EncryptedDocumentException, IOException
	{
		UtilityClassObject.getTest().log(Status.INFO,"navigate to Org Page");
		String orgName=eLib.getDataFromExcel("OrgTestCase", 2, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getIcon().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create New Org Page");
		CreateNewOrgPage cop=new CreateNewOrgPage(driver);
		cop.getOrgName().sendKeys(orgName);
		cop.getSave().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to OrgInfo Page");
		OrgInformationPage oip=new OrgInformationPage(driver);
		String headerText=oip.getHeaderMsg().getText();
		boolean data =headerText.contains(orgName);
				Assert.assertEquals(data, true);
				
	}	
	@Test(groups = {"RegressionTest"})
	public void createOrgWithIndusTest() throws EncryptedDocumentException, IOException
	{
		UtilityClassObject.getTest().log(Status.INFO,"navigate to OrgInd Page");
		
		String orgName = eLib.getDataFromExcel("OrgTestCase", 5, 2) + jLib.getRandomNumber();
		String Industry=eLib.getDataFromExcel("OrgTestCase", 5, 3);
		String Type =eLib.getDataFromExcel("OrgTestCase", 5, 5);
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
		
		UtilityClassObject.getTest().log(Status.INFO, orgName +"navigate to create OrgIndInfor Page");
		
		OrgInformationPage oip=new OrgInformationPage(driver);
		boolean IndName = oip.getIndName().isSelected();
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(IndName);
		sa.assertAll();
			
			}
	}
