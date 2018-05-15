package Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class Inbox extends Main {

	
	public Inbox()
	{
		
	}
	

	public void delete()
	{
		driver.findElement(By.xpath("//div[@class='T-Jo-auh']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Delete']")).click();
		Reporter.log("<font color='red'><b>Reg page not displayed</b></font>");
		
	}
	
}
