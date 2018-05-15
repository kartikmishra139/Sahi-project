package selinium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Row;

public class ReadWriteNumberExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fin=new FileInputStream("D:\\Data.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fin); //Create WorkBook Object
		HSSFSheet ws=wb.getSheet("Sheet1");
		
		FileOutputStream fout=new FileOutputStream("D:\\Data.xls");
		Row row;
		
		for(int i=1;i<=ws.getLastRowNum();i++)
		{
			row=ws.getRow(i);
		double	d=1;
			for(int j=0;j<ws.getLastRowNum();j++)
			{
				System.out.println(row.getCell(j).getNumericCellValue());
				System.out.println("==========");
				
				d*=row.getCell(j).getNumericCellValue();
				System.out.println(d);
				row.createCell(2).setCellValue(d);
				
				
			}
			
			
			
		}
		
		wb.write(fout);    //Write all workbook data into file
		fin.close(); 
		fout.close();
		wb.close();

	}

}
