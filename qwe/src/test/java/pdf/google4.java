package pdf;
import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class google4
{
	List<String> resultList=new ArrayList<String>();
    pdfUtility pdfUtility=new pdfUtility();
	FirefoxDriver driver;
		  	
    @DataProvider(name="dp1")
	public String[] testdata() throws Exception
	{
		return new String[] {"selenium"};
	}	
			
	@BeforeClass
	public void open()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.google.com");
				
		}
	
	@BeforeMethod
	public void Setup() 
	{
	//add test result header information to the resultList
	resultList.add("Step Id, Action,Expected Result, Actual Result, Test Result");
	try
	 {
		 //initialize Firefox driver
	   driver=new FirefoxDriver();
		//obtain windows handler name
		String windowsHandle=driver.getWindowHandle();
		 //assert that a window has been launched
	   assertEquals(true, windowsHandle.length()>0);
		//add a test step string to the resultList as pass after assertion true
		resultList.add("1, Open Browser,Browser should open, Browser Opened, Pass"+windowsHandle);
	 }
	catch(Exception e)
	 {
	    //add a test step string to the resultList as fail after assertion true
		resultList.add("1, Open Browser,Browser should open, Browser NOT Opened, Fail");  
	 }
			 
   }
			
	@Test(dataProvider="dp1")
	public void search(String br) throws Exception
	{
		driver.findElement(By.id("lst-ib")).sendKeys(br);
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(5000);
		driver.navigate().back();
	}
	@AfterClass
	public void ending() throws Exception
	{
				
		pdfUtility.WriteTestResultToPdfFile("TestResult.pdf", resultList);
		driver.close();
	}
			

}
		    
			
			

			
			

		


