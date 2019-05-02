package Guru99.model.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Guru99.model.pages.HomePage;
import Guru99.model.utilities.LoginDataExcelUtility;

public class HomeTests extends BaseTests {
	
	@Test
	@Disabled
	public void verifyLogin() throws IOException
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
		assertEquals("http://www.demo.guru99.com/V4/manager/Managerhomepage.php", homePage.getUrl());
		
	}
	
	@Test
	public void ValidateLogin() throws IOException
	{
		HomePage homePage = new HomePage(driver);
		homePage.Login();
	}
}
