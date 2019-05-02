package Guru99.model.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import Guru99.model.utilities.CustomerData;
import Guru99.model.utilities.LoginData;
import Guru99.model.utilities.LoginDataExcelUtility;

public class HomePage {
	
	
	public WebDriver driver;
	public String username;
	public String password;
	ArrayList<LoginData> Logindatalist;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void setUsername(String username)
	{
		driver.findElement(By.name("uid")).sendKeys(username);
	}
	public void setPassword(String password)
	{
		driver.findElement(By.name("password")).sendKeys(password);
	}
	public void clickLoginButton()
	{
		driver.findElement(By.name("btnLogin")).click();
	}
	public String getUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	
	public void Login() throws IOException
	{
		LoginDataExcelUtility ld = new LoginDataExcelUtility();
		//Logindata = ld.LoginData();
		XSSFSheet sheet = ld.getSheet();
		Iterator<Row> Rows = sheet.iterator();
		
		ArrayList<LoginData> Logindatalist = new ArrayList<LoginData>();
		while(Rows.hasNext())
		{
			Row r = Rows.next();
			LoginData userData= new LoginData();
			userData.username = r.getCell(0).getStringCellValue();
			userData.password = r.getCell(1).getStringCellValue();
			Logindatalist.add(userData);
			
		}
		
		
		System.out.println(Logindatalist.size());
		
		for(int i = 0;i<Logindatalist.size();i++)
		{
			LoginData hp = Logindatalist.get(i);
			driver.findElement(By.name("uid")).sendKeys(hp.username);
			driver.findElement(By.name("password")).sendKeys(hp.password);
			driver.findElement(By.name("btnLogin")).click();
			
			try{ 
			    
		       	Alert alt = driver.switchTo().alert();
				Object actualBoxtitle = alt.getText();
				alt.accept();
				if (actualBoxtitle.equals("User or Password is not valid")) {
				    System.out.println("Test case SS[" + i + "]: Passed"); 
				} 
			else {
				    System.out.println("Test case SS[" + i + "]: Failed");
				}
			}    
		    catch (NoAlertPresentException Ex){ 
		    	String actualTitle = driver.getTitle();
			
				if (actualTitle.equals("Guru99 Bank Manager HomePage")) {
				    System.out.println("Test case SS[" + i + "]: Passed");
				} else {
				    System.out.println("Test case SS[" + i + "]: Failed");
				}
				
	        }
			driver.navigate().back();
			
		}
		
	}

}
