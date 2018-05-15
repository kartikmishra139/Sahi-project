package Gmail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SanityTest extends Main{
	
	
	@Parameters({"browser"})
	@Test
	public void testing(String brname) throws InterruptedException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		
		if(brname.matches("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver=new FirefoxDriver();	
		}
		if(brname.matches("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
			driver=new ChromeDriver();		
			}
		
		FileInputStream fin=new FileInputStream("D:\\Data.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fin); //Create WorkBook Object
		HSSFSheet ws=wb.getSheet("Sheet3"); 
		Row row;
		String classname,methodname;
		
		for(int r=1;r<=ws.getLastRowNum();r++)
		{
			row=ws.getRow(r);
			if(row.getCell(4).getStringCellValue().matches("yes"))
			{
				classname=row.getCell(2).getStringCellValue();
				methodname=row.getCell(3).getStringCellValue();
				Class c=Class.forName(classname); // load class into memory
				Method m=c.getMethod(methodname, null); //get method in class
				Object obj=c.newInstance(); //create new instance
				m.invoke(obj, null);
			}
			
		}
		
		
	/*	Home h =new Home(driver);
		h.login();
		
		Compose c=new Compose(driver);
		c.sendmail();
		c.signout();*/
		
	}
}
