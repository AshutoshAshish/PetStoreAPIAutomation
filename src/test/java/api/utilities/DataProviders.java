package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	String path = System.getProperty("user.dir")+"\\testData\\UserTDD.xlsx"; 
	ExcelUtil xl= new ExcelUtil(path);
	
	@DataProvider(name="Data")
	public String[][] getAllUserData() throws IOException {
		
		int rowNum= xl.getRowCount("Sheet1");
		int cellNum= xl.getCellCount("Sheet1", 1);
		
		String[][] apiData= new String[rowNum][cellNum];
		
		for(int i=1; i<=rowNum; i++) {
			
			for(int j=0; j<cellNum; j++) {
				apiData[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		
		return apiData;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUsernames() throws IOException {
		
		int rowNum= xl.getRowCount("Sheet1");
		String[] apiData = new String[rowNum];
		
		for(int i=1; i<=rowNum; i++) {
			apiData[i-1] = xl.getCellData("Sheet1", i, 1);
		}
		
		return apiData;
	}
	
	

}
