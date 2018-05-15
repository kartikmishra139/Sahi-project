package selinium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadFromXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		
		
		FileInputStream fin=new FileInputStream("D:\\Facebook.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fin); //Create WorkBook Object
		HSSFSheet ws=wb.getSheet("Sheet2");
		
		Row row;
		File fxml=new File("D:\\abc.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document doc = null;
	doc=db.parse(fxml);
	
	System.out.println("Debug: Root element"+ doc.getDocumentElement().getNodeName());
	org.w3c.dom.NodeList name=(org.w3c.dom.NodeList) doc.getElementsByTagName("username");
	org.w3c.dom.NodeList npwd=(org.w3c.dom.NodeList) doc.getElementsByTagName("password");
	NodeList user= doc.getElementsByTagName("user");
	
	
	for(int i=0;i<name.getLength();i++)
	{
		row=ws.createRow(i);
		
		row.createCell(0).setCellValue(name.item(i).getTextContent());
		row.createCell(1).setCellValue(npwd.item(i).getTextContent());
		row.createCell(2).setCellValue(user.item(i).getAttributes().getNamedItem("id").getNodeValue());
		row.createCell(3).setCellValue(name.item(i).getAttributes().getNamedItem("eid").getNodeValue());
		row.createCell(4).setCellValue(name.item(i).getAttributes().getNamedItem("eid").getNodeName());
		
	}

	FileOutputStream fout=new FileOutputStream("D:\\Facebook.xls");
	wb.write(fout);    //Write all workbook data into file
	fin.close(); 
	fout.close();
	wb.close();
	
	
	}

}
