package practiceDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createOrgWithDtProTest1 {

	@Test(dataProvider = "getData")
	public void createcontactFromDP1(String FirstName, String LastName, long phoneNumber)
	{
		System.out.println("FirstName: "+ FirstName+ ",LastName:" + LastName +",phoneNumber :"+phoneNumber);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]= "Suma";
		objArr[0][1]="QA";
		objArr[0][2]=123456789l;
				
		objArr[1][0]="Divya";
		objArr[1][1]="PA";
		objArr[1][2]=345678902l;
		
		objArr[2][0]="Suneel";
		objArr[2][1]="BA";
		objArr[2][2]=928323219l;
		
		return objArr;
		
	}
}
