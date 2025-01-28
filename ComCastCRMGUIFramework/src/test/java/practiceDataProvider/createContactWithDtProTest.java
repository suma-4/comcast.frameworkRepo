package practiceDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createContactWithDtProTest {

	@Test(dataProvider = "getData")
	public void createcontactFromDP(String FirstName, String LastName)
	{
		System.out.println("FirstName: "+ FirstName+ ",LastName:" + LastName);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][2];
		objArr[0][0]= "Suma";
		objArr[0][1]="QA";
				
		objArr[1][0]="Divya";
		objArr[1][1]="PA";
		
		objArr[2][0]="Suneel";
		objArr[2][1]="BA";
		
		return objArr;
		
	}}
