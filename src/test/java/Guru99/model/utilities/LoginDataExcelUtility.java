package Guru99.model.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import Guru99.model.pages.HomePage;

public class LoginDataExcelUtility {
	
	
		
	//public ArrayList<HomePage> LoginData() throws IOException
	public XSSFSheet getSheet() throws IOException
	{		
	FileInputStream fis = new FileInputStream("C:\\Users\\sshanmuganathan\\Desktop\\Login.xlsx");
		//FileInputStream fis = new FileInputStream(System.getProperty(("user.dir") + "\\Resources\\Login.xlsx"));
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Logindata");
	return sheet; 
	
	
	
	}

}
