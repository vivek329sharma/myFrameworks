package utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	
	public ExcelDataProvider() {
		
//		File src = new File("./src/main/java/dataSheets/testData.xlsx");
		try {
//			FileInputStream input = new FileInputStream(src);
			wb = new XSSFWorkbook("./src/main/java/dataSheets/testData.xlsx");		    
		} catch (Exception e) {
			System.out.println("Excel file not loaded properly"+e.getMessage());
		}
	}
	
	public void getRowColumnCount(String sheetName, int rowNum) {
		sheet=wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()+1;
	    System.out.println("Total Rows = " +rowCount);
	    row = sheet.getRow(rowNum);
	    int colCount = row.getLastCellNum()-1;
	    System.out.println("Total Columns = " +colCount);
	}
	
	public String getStringData(String sheetName, int rowNum, int columnNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
	}
	//Method overloading example
	public String getStringData(int sheetIndex, int rowNum, int columnNum) {
		return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(columnNum).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int rowNum, int columnNum) {

		return wb.getSheet(sheetName).getRow(rowNum).getCell(columnNum).getNumericCellValue();
	}
	
}
