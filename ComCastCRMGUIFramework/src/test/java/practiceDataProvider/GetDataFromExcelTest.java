package practiceDataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class GetDataFromExcelTest {

	ExcelUtility exLib=new ExcelUtility();
	@Test(dataProvider ="getExcelData")
	public void getData(String BrandName, String ProductName) throws EncryptedDocumentException, IOException
	{
		BrandName=exLib.getDataFromExcel("Amozon", 0, 1);
		ProductName=exLib.getDataFromExcel("Amazon", 1, 1);
		System.out.println(BrandName+ " " +ProductName);
	}
	@DataProvider
	public Object[][] getExcelData() throws EncryptedDocumentException, IOException
	{
		
		int rowcount = exLib.getRowCount("Amazon");
		Object[][] obj=new Object[rowcount][2];
		for(int i=0; i<=rowcount; i++)
		{
		obj [i][0]=exLib.getDataFromExcel("Amazon", i+1, 0);
		obj [i][1]=exLib.getDataFromExcel("Amazon", i+1, 1);
		
		}
		return obj;
	}
}
