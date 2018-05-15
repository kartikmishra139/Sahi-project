package Gmail;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ATUReportsListener.class,MethodListener.class,ConfigurationListener.class})
public class Home extends Main{

	{
		System.setProperty("atu.reporter.config", "D:\\Selenium\\Testing\\Selinium\\atu.properties");
	}
	
	public Home()
	{
		
	}
	
	 String url="https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
	 
	
	 public void open() 
	 {
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
			// ATUReports.add("Link is matching :",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
				

		    driver.manage().window().maximize();
		    driver.get(url);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		}
	
	 
	 public void login() throws InterruptedException, IOException
	 {
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 /*logger=extent.createTest("passtest");
  	         logger.log(Status.PASS	, "Result are displayed");*/
  	     
  	     /* String path="D:\\gmail.png";
  	      capturescrren(driver, path);*/
  	    //  logger.log(Status.PASS,(Markup) logger.addScreenCaptureFromPath(path));
  	    ATUReports.add("Link is matching :",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			
  	      	  /*driver.findElement(By.name("Email")).sendKeys("Akhate31@gmail.com");
		       driver.findElement(By.xpath("//span[text()='Next']")).click();
		       driver.findElement(By.name("signIn")).click();
		       Thread.sleep(20000);
		       driver.findElement(By.name("password")).sendKeys("samsung123#");
		       driver.findElement(By.xpath("//span[text()='Next']")).click();*/  
		     
		}
	 
	 
	 public void createAcc() throws InterruptedException {
		 System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(url);
		 driver.findElement(By.xpath("//span[text()='Create account']")).click();
		 Thread.sleep(20000);
		 driver.get(url);
	 }
	 
}
