package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomizeDataProv {

	 @DataProvider(name="FillTheForm")
	 public Object[][] getData()
{
		 Object[][] data= {{"sinchan","suma@123","sinchan@gmail.com","www.sinchan.com", "2289", "123891", "sih329n"},
				{"suma","seema@123", "suma@gmail.com", "www.suma.com", "47920", "102831029", "syhdn20398"},
				{"Thanish", "Thanish@123", "thanish@gmail.com","wwww.thanish.com", "12937", "3891708","fdj238un"}};
			 return data;
		 }
}

