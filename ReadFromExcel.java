package selinium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ReadFromExcel {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fin=new FileInputStream("D:\\Data.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fin); //Create WorkBook Object
		HSSFSheet ws=wb.getSheet("Sheet1");   // Gte sheet in WorkBook
		
		
		Row row;
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			row=ws.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				System.out.println(row.getCell(j).getStringCellValue());
			}
		}
		fin.close();

	}

}
