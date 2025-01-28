package com.comcast.crm.BaseTestUtility;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleBaseClass {

	@BeforeSuite
	public void configBS()
	{
		System.out.println("Connect to DB");
	}
	
	@Test
	public void testBase()
	{
		System.out.println("perform actions");
	}
	
	@BeforeMethod
	public void AconfigBM()
	{
		System.out.println("login");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("Launch browser");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("login");
	}
	
	@BeforeSuite
	public void aconfigBS()
	{
		System.out.println("Connect to SQL");
	}
	
	@AfterSuite
	public void sconfigAS()
	{
		System.out.println("close DB connection");
	}
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("Logout");
	}
	
	@BeforeMethod
	public void bconfigBM()
	{
		System.out.println("login");
	}

	@AfterMethod
	public void hconfigAM()
	{
		System.out.println("Logout");
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("close browser");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("close DB connection");
	}
	
	
}
