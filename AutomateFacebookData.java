package selinium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateFacebookData {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
	    FirefoxDriver driver =new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.facebook.com/");
	   
	    
	    
        FileInputStream fin=new FileInputStream("D:\\Facebook.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fin); //Create WorkBook Object
		HSSFSheet ws=wb.getSheet("Sheet1");
	    
		
		
		Row row;
		for(int i=1;i<=ws.getLastRowNum();i++)
		{
			row=ws.getRow(i);
			
			
			
				
				  driver.findElement(By.name("firstname")).sendKeys(row.getCell(0).getStringCellValue());
				    driver.findElement(By.name("lastname")).sendKeys(row.getCell(1).getStringCellValue());
				    driver.findElement(By.name("reg_email__")).sendKeys(row.getCell(2).getStringCellValue());
				    driver.findElement(By.name("reg_email_confirmation__")).sendKeys(row.getCell(3).getStringCellValue());
				    driver.findElement(By.name("reg_passwd__")).sendKeys(row.getCell(4).getStringCellValue());
				    
				  
				    
					driver.findElement(By.id("day"));
				    driver.findElement(By.id("day")).sendKeys(String.valueOf(row.getCell(5).getNumericCellValue()));
				    driver.findElement(By.id("month")).sendKeys(row.getCell(6).getStringCellValue());;
				    driver.findElement(By.id("year")).sendKeys(String.valueOf(row.getCell(7).getNumericCellValue()));
				    
				    if(row.getCell(8).getStringCellValue().matches("Male")) 
				    {
				    	 driver.findElement(By.xpath("//label[text()='Male']")).click();
				    	
				    }
				   
				    else
				    {
				    	driver.findElement(By.xpath("//label[text()='Female']")).click();
				    }
				   // driver.findElement(By.name("websubmit")).click();
				    Thread.sleep(5000);
				    driver.navigate().refresh();
			
			
			
			
		}

	}

}
