package selinium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class REadWriteToExcel {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        FirefoxDriver driver =new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        
        
        FileInputStream fin=new FileInputStream("D:\\Data.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fin); //Create WorkBook Object
		HSSFSheet ws=wb.getSheet("Sheet2");
		
	
		Row row;
		for(int i=1;i<=ws.getLastRowNum();i++)
		{
			row=ws.getRow(i);
			
			
				driver.findElement(By.id("lst-ib")).sendKeys(row.getCell(0).getStringCellValue());
				 driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
				// String str=  driver.findElement(By.xpath("//div[@id='resultStats']")).getText();
				  String strr=  driver.findElement(By.id("resultStats")).getText();
				System.out.println(strr);
				System.out.println("========================");
				
				// row=ws.createRow(1);
				row.createCell(1).setCellValue(strr);	
				
			
				driver.navigate().back();
				
			
			
		}
		FileOutputStream fout=new FileOutputStream("D:\\Data.xls");
		wb.write(fout);    //Write all workbook data into file
		fin.close(); 
		fout.close();
		wb.close();
	}

}
