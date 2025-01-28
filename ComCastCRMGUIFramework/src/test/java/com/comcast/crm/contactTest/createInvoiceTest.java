package com.comcast.crm.contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTestUtility.BaseUtilityClass;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImpClass.class)
public class createInvoiceTest extends BaseUtilityClass
{
	@Test
	public void InvoiceTest()
	{
		System.out.println("execute Invoice Test");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step=1");
		System.out.println("step=2");
		System.out.println("step=3");
		System.out.println("step=4");
	}

	@Test
	public void DeleteInvoiceTest()
	{
		System.out.println("execute DeleteInvoice Test");
		System.out.println("step=1");
		System.out.println("step=2");
		System.out.println("step=3");
		System.out.println("step=4");
	}
	
}
