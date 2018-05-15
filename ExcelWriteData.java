package selinium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExcelWriteData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fin=new FileInputStream("D:\\Data.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fin); //Create WorkBook Object
		HSSFSheet ws=wb.getSheet("Sheet1");   // Gte sheet in WorkBook
		HSSFSheet wss=wb.getSheet("Sheet2");
		
		
		
		
		
		Row row=ws.createRow(0); // Create row in sheet
		row.createCell(0).setCellValue("Seklenium");
		row.createCell(1).setCellValue("qtp");
		row.createCell(2).setCellValue("Blueprism");
		
		
		 row=ws.createRow(1); // Create row in sheet
		row.createCell(0).setCellValue("100");
		row.createCell(1).setCellValue("101");
		row.createCell(2).setCellValue("102");
		
		
		 row=wss.createRow(0); // Create row in sheet
		row.createCell(0).setCellValue("Seklenium");
		row.createCell(1).setCellValue("qtp");
		row.createCell(2).setCellValue("Blueprism");
		
		
		//File to Write
		
		FileOutputStream fout=new FileOutputStream("D:\\Data.xls");
		wb.write(fout);    //Write all workbook data into file
 		fin.close();  //close the file
		fout.close();
		
		

	}

}
