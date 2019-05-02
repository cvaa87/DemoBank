package Guru99.model.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import Guru99.model.pages.CustomerDataPage;
import Guru99.model.pages.HomePage;

public class ExcelUtility extends CustomerDataPage {
//public CustomerData[] listOfCustomer;

	ArrayList<CustomerData> listOfCustomer = new ArrayList<CustomerData>();

	public ExcelUtility(WebDriver driver) {
		super(driver);
		// listOFCustomer = new CustomerData();

	}

	public ArrayList<CustomerData> getData() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\sshanmuganathan\\Desktop\\NewCustomer.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetAt(i).getSheetName().contentEquals("Data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row r = rows.next();

					CustomerData person = new CustomerData();

					person.name = r.getCell(0).getStringCellValue();
					person.gender = r.getCell(1).getStringCellValue();
					person.dob = r.getCell(2).getDateCellValue();
					//System.out.println("DOB"+person.dob);
					person.address = r.getCell(3).getStringCellValue();
					person.city = r.getCell(4).getStringCellValue();
					person.state = r.getCell(5).getStringCellValue();
					person.Pin = NumberToTextConverter.toText(r.getCell(6).getNumericCellValue());
					//person.Pin = r.getCell(6).toString();
					//person.mobilenumber = r.getCell(7).toString();
					person.mobilenumber = NumberToTextConverter.toText(r.getCell(7).getNumericCellValue());
					person.email = r.getCell(8).getStringCellValue();
					person.password = r.getCell(9).getStringCellValue();

					listOfCustomer.add(person);

				}

			}

		}
		// return person;
		return listOfCustomer;

	}

}
