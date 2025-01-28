package practiceDataProvider;

import org.testng.annotations.Test;

public class DtProTest {

	@Test(dataProvider= "testData", dataProviderClass = DtProclass.class)
	public void getTestData(String FirstName, String LastName, long phoneNumber)
	{
		System.out.println("FirstName:" + FirstName);
		System.out.println("LastName: "+LastName );
		System.out.println("phoneNumber:"+ phoneNumber);
	}
}
