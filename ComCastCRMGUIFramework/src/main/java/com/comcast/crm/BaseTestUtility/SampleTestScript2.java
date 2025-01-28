package com.comcast.crm.BaseTestUtility;

import org.testng.annotations.Test;

public class SampleTestScript2 extends SampleBaseClass{

	@Test
	public void clearContactTest()
	{
		System.out.println("Contact-created");
	}
	
	@Test
	public void OrgTest()
	{
		System.out.println("Org-created");
	}
	
	@Test
	public void DeleteOrgTest()
	{
		System.out.println("Org-deleted");
	}
	
}
