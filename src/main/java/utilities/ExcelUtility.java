package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	//constructor for ExcelUtil
	
	public ExcelUtility(String path)
	{
		this.path = path;
	}
	
	//method to get row count from a excel sheet
	
	public int getRowCount(String sheetName) throws IOException
	{
		fi = new FileInputStream(path);			// Open the file for reading
		workbook = new XSSFWorkbook(fi);		// Load the workbook
		sheet = workbook.getSheet(sheetName);	// Select the sheet
		int rowcount = sheet.getLastRowNum();	// Get last used row index (0-based
		workbook.close();
		fi.close();
		return rowcount;
	}
	
	//method to get cell count from a row
	
	public int getCellCount(String sheetName, int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);				// Get the specific row
		int cellcount = row.getLastCellNum();	// Returns column count in that row
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	//method to get cell data from a particular row and column
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try
		{
			data = formatter.formatCellValue(cell);		//returns the formatted value of a cell as a string regardless of type of data a cell have
		}
		catch(Exception e)
		{
			data = "";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	//method to write data into a cell of a workbook
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
	{
		File xlfile = new File(path);
		if(!xlfile.exists())	//if file does not exists then create new file
		{
			workbook = new XSSFWorkbook();		// Create new workbook
			fo = new FileOutputStream(path);
			workbook.write(fo);				// Save it
		}
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetName)==-1)	//if sheet does not exists then create a new sheet
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null)	//if row does not exists then create a new row
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);
		
		cell = row.createCell(colnum);		// Create the cell
		cell.setCellValue(data);			// Set the value
		
		fo = new FileOutputStream(path);	// Write back to file
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
		
	}
	
	//method to fill green color into a cell
	
	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(path);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
	}
	
	//method to fill red color into a cell
	
	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(path);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
	}
	
}
