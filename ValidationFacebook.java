package selinium;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ValidationFacebook {

	
	
	  static FirefoxDriver driver =new FirefoxDriver();
	
	  public static void validate_fname(WebElement w,String inputtext,String validation)
		{
		  w.clear();
			w.sendKeys(inputtext);
			driver.findElement(By.name("websubmit")).click();	
			
			
			 if(validation.matches("valid"))
			 {
				 try
				 {
					 if(driver.findElement(By.xpath("//button[contains(.,'Connect to Gmail')]")).isDisplayed())
					 {
						 System.out.println("Valid input          :          passed......able to create account");
						 driver.findElement(By.id("userNavigationLabel")).click();
						 Thread.sleep(2000);
						 driver.findElement(By.xpath("//span[contains(.,'Log Out']")).click();
						 Thread.sleep(2000);
						
					 }
				  }
				  catch(Exception e)
				 {
					  System.out.println("Valid input          :          Failed............not working as expected");
				 }
				 
				 
			 }	
			
			if(validation.matches("Invalid"))
			 {
				 boolean e=driver.findElement(By.xpath("//i[@class='_5dbc img sp_6E_d5dmi7E6 sx_f40ac8']")).isDisplayed();
				 if(e==false)
				 {
					 System.out.println(" InValid input          :          passed......error message is as expected");
				 }
				 else
				 {
					 System.out.println("In Valid input          :          Failed......error message is NOT expected");
				 }
			 }
			
		}
	  
	  
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
	  
	    driver.manage().window().maximize();
	    
	    driver.get("https://www.facebook.com/");
	    
	    driver.findElement(By.name("firstname")).sendKeys("Adrak");
	    driver.findElement(By.name("lastname")).sendKeys("Lasun");
	    driver.findElement(By.name("reg_email__")).sendKeys("adrak.lasun@gmail.com");
	   // driver.findElement(By.name("reg_email_confirmation__")).sendKeys("adrak.lasun@gmail.com");
	    driver.findElement(By.name("reg_passwd__")).sendKeys("AdrakLasun");
	    
	  
	    
		driver.findElement(By.id("day"));
	    new Select(driver.findElement(By.id("day"))).selectByVisibleText("5");
	    new Select(driver.findElement(By.id("month"))).selectByVisibleText("Aug");
	    new Select(driver.findElement(By.id("year"))).selectByVisibleText("1982");
	    
	    driver.findElement(By.xpath("//label[text()='Male']")).click();
	    
	    WebElement fname=driver.findElement(By.name("reg_email_confirmation__"));
	    validate_fname(fname,"adrak.lasun@gmail.com", "valid");
	    validate_fname(fname,"adrakgmail.com", "Invalid");
	   	    

	}

	
	
	
	
	
}
