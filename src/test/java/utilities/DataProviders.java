package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider utility
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\src\\test\\resources\\Opencart_LoginData.xlsx";	//fetching excel file from testData folder
		
		ExcelUtility xlutil = new ExcelUtility(path);	//creating an object of ExcelUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata [][] = new String[totalrows][totalcols];	//created a 2D array to store excel data
		
		for(int i=1;i<=totalrows;i++)	//loop to iterate over rows
		{
			for(int j=0;j<totalcols;j++)	//loop to iterate over columns
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;	//returning excel data as 2D array
	}
}
