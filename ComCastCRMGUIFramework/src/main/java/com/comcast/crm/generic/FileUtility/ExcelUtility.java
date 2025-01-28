package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/script.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
			wb.close();
		return data;
	}
	public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream("./TestData/script.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	int rowCount = wb.getSheet(SheetName).getLastRowNum();
	wb.close();
	return rowCount;
	}
	
	public void setDataIntoexcel(String SheetName2, int RowNum2, int CellNum2, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/script.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(SheetName2).getRow(RowNum2).createCell(CellNum2).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./TestData/script.xlsx");
		wb.write(fos);
		wb.close();
	}	}

