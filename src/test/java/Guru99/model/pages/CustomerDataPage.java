package Guru99.model.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Guru99.model.utilities.CustomerData;
import Guru99.model.utilities.ExcelUtility;

public class CustomerDataPage extends HomePage {
	
	ArrayList <CustomerData> listOfCustomer;

	public CustomerDataPage(WebDriver driver) {
		super(driver);

	}

	public void clickNewCustomer() {
		driver.findElement(By.linkText("New Customer")).click();
	}

		
	public void addCustomer() throws IOException {

		ExcelUtility ex = new ExcelUtility(driver);
		listOfCustomer = ex.getData();
		
		for (int i =0 ;i < listOfCustomer.size()-3; i++)
		{
		CustomerData person= listOfCustomer.get(i);
		
		driver.findElement(By.name("name")).sendKeys(person.name);
		
		String gender = person.gender;
		if (gender == "male") {
			driver.findElement(By.cssSelector("input[value='m']")).click();
		}
		else
		driver.findElement(By.cssSelector("input[value='f']")).click();
		//System.out.println(person.dob.toString());
		
		//driver.findElement(By.name("dob")).sendKeys(person.dob.toString());
		
		//System.out.println("Value in date "+ driver.findElement(By.name("dob")).getText());
		
		driver.findElement(By.id("dob")).sendKeys(person.dob.toString());
		driver.findElement(By.name("addr")).sendKeys(person.address);
		driver.findElement(By.name("city")).sendKeys(person.city);
		driver.findElement(By.name("state")).sendKeys(person.state);
		driver.findElement(By.name("pinno")).sendKeys(person.Pin);
		driver.findElement(By.name("telephoneno")).sendKeys(person.mobilenumber);
		driver.findElement(By.name("emailid")).sendKeys(person.email);
		driver.findElement(By.name("password")).sendKeys(person.password);

		
	driver.findElement(By.name("sub")).click();
		}
	}

	public void clickSubmitButton() {
	//	driver.findElement(By.name("sub")).click();
	}

	public void clickResetButton() {
		driver.findElement(By.name("res")).click();
	}
}
