package com.comcast.crm.BaseTestUtility;

import org.testng.annotations.Test;

public class SampleTestScript extends SampleBaseClass{

	@Test
	public void createContactTest()
	{
		System.out.println("Contact-created");
	}
	
	@Test
	public void createOrgTest()
	{
		System.out.println("Org-created");
	}
	
	@Test
	public void AreateOrgTest()
	{
		System.out.println("Org-deleted");
	}
}
