package Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


public class Compose extends Main {

	
	
	public Compose()
	{
		
	}
	
	public static void main(String[] args)
	{
		
	}

	public void sendmail() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.findElement(By.xpath("//span[text()='TO']")).click();
		Thread.sleep(10000);
		driver.findElement(By.name("to")).sendKeys("akhate443@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("First Mail");
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("hi bb how are u");
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		
	}
	
	public void signout() {
		
		 driver.findElement(By.xpath("//a[@role='button']")).click();
	       driver.findElement(By.xpath("//span[text()='Gmail']")).click();
	       driver.findElement(By.xpath("//a[text='Sign out']")).click();
	       Reporter.log("<font color='red'><b>Reg page not displayed</b></font>");
		
	}
	
	
}
