package SELENIUM.DEMO.lecturaExcel;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;






public class Reade_Excel3 {
	
	public String path;
	FileInputStream fis;
		
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFRow row;
	HSSFCell cell;
	
	
	
	public Reade_Excel3(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int col_Num = 0;
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			HSSFRow row = sheet.getRow(0);
			
			for (int i = 1; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
				}
			}
			row = sheet.getRow(rowNum - 1);
			HSSFCell cell = row.getCell(col_Num);
			
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	public String getCellData(String sheetName, int colName, int rowNum) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			HSSFRow row = sheet.getRow(0);
			row = sheet.getRow(rowNum - 1);
			HSSFCell cell = row.getCell(colName);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	public int getRowCount(String sheetName) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				return 0;
			} else {
				sheet = workbook.getSheetAt(index);
				int number = sheet.getLastRowNum() + 1; //colocamos el 0 porque no cuenta la primer fila de encabezado de columna, si queremos que cuente todos los renglones aun el encabezado colocar el 1
				
				return number;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public int getColumnCount(String sheetName) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				return 0;
			} else {
				sheet = workbook.getSheet(sheetName);
				row = sheet.getRow(0);
				return row.getLastCellNum();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "//src//test//java//SELENIUM//DEMO//lecturaExcel//Registros.xls";
		
		Reade_Excel3 obj = new Reade_Excel3(path);
		                                                 //Col, Row
		System.out.println(obj.getCellData("DatosRegistro", 0, 2));
		System.out.println(obj.getRowCount("DatosRegistro"));
		//System.out.println(obj.getColumnCount("DatosRegistro"));
	}
	
	
	
	
	
	
	
	
	
	

}
