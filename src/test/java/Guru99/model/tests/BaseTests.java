package Guru99.model.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {
	
	protected WebDriver driver;
	
	@BeforeEach
	public void startUp()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://www.demo.guru99.com/V4/");
	}
	
	@AfterEach
	public void shutDown()
	{
		//driver.quit();
	}

}
