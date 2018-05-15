	package Gmail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ATUReportsListener.class,MethodListener.class,ConfigurationListener.class})
public class Main 
{
	
	{
		System.setProperty("atu.reporter.config", "D:\\Selenium\\Testing\\Selinium\\atu.properties");
	}

	public static WebDriver driver;
	
	/* public static ExtentReports extent;
	 public static	ExtentTest logger;
	 public static	ExtentHtmlReporter htmlReporter;
	
	@BeforeSuite
	public void init()
	{
		htmlReporter=new ExtentHtmlReporter("D:\\Gmail.html");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Google");
		extent.setSystemInfo("Environment", "Test Env");
		extent.setSystemInfo("User Name", "Lord");
		
		htmlReporter.config().setDocumentTitle("Mera report");
		htmlReporter.config().setReportName("Google Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);	
		
	}

	public void capturescrren(WebDriver diver,String Location)
	{
		 File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try
		 {
			 FileUtils.copyFile(f, new File(Location));
		 }
		 catch (Exception e) {
			
		}
	}

	@AfterSuite
	public void ending()
	{
		extent.flush();
	}*/
	
	
}
