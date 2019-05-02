package Guru99.model.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import Guru99.model.utilities.CustomerData;
import Guru99.model.pages.CustomerDataPage;
import Guru99.model.utilities.ExcelUtility;
import Guru99.model.pages.HomePage;

public class AddCustomerTests extends BaseTests {
	
	@Test
	public void addCustomerDetails() throws IOException
	{
		HomePage homePage = new HomePage(driver);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\sshanmuganathan\\DemoBank\\src\\test\\java\\Data.properties");
		prop.load(fis);
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		homePage.setUsername(username);
		homePage.setPassword(password);
		homePage.clickLoginButton();
		CustomerDataPage add = new CustomerDataPage(driver);
		add.clickNewCustomer();
		add.addCustomer();
		add.clickSubmitButton();
				
	}

	
}
