package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleTest {
	
	private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
	private static XSSFRow row;
    private static XSSFCell cell;
	
	
	 public String getCellData(int i,int j) throws Exception{
		 	

			String excelFilePath="C:\\Users\\USER\\eclipse-workspace\\DemoPractices\\ExcelData\\MyData.xlsx";
			File file =    new File(excelFilePath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
			XSSFSheet sheet=workbook.getSheet("Test1");
		 	
	       //getting the cell value from rowNumber and cell Number
	        String cell =sheet.getRow(i).getCell(j).getStringCellValue();
	        //String fName=getCellData(0, 0);
	        System.out.println("the value cell is : "+cell);
			return cell;
	        
	       
	    }
	
}
