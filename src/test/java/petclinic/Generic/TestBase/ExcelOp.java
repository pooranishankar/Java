package petclinic.Generic.TestBase;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOp
{
	static FileInputStream fis;
	static Workbook wb1;
	public static XSSFSheet sheet;
	private static XSSFSheet ExcelWSheet;
	static DataFormatter formatter = new DataFormatter(Locale.US);
	public static int totalRows;
	
			//Load Excelfile to read data called in @BeforeClass of testclass
				public static void loadExcel(String excelname) throws IOException
				{
					File datafile = null;
					if(excelname=="AssetsTestData")
					datafile = new File("./src/Assets/ParameterisedTestData/AssetsTestData.xlsx");
					else if(excelname=="CartridgesTestData")
					datafile = new File("./src/Cartridges/ParameterisedTestData/CartridgesTestData.xlsx");
					/*else
					datafile = new File("./src/Clove/ParameterisedTestData/CloveTestData.xlsx");*/
					else
						datafile = new File("./src/test/java/Clove/ParameterisedTestData/LdapTestData.xlsx");
					
					try {
						fis = new FileInputStream(datafile);
						} 
					catch (FileNotFoundException e) 
						{
						e.printStackTrace();
						}
					try {
						wb1 = new XSSFWorkbook(fis);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
								
				}
				
			
				
				//Read data from excel which was loaded in loadExcel method
				public static String ReadExcelData(String shname, int rowno, int colno)
				{
					String data ="";
					try{
						if(wb1==null)
						{
						   System.out.println("wb is null");
						}
						sheet=(XSSFSheet)wb1.getSheet(shname);
						data = formatter.formatCellValue(sheet.getRow(rowno).getCell(colno));				
						//data = sheet.getRow(rowno).getCell(colno).getStringCellValue();
						//System.out.println(data);
						}
					catch(Exception ex)
						{
						System.out.println("eror "+ex.toString());
						}
					return data;
					
				}
				
				
				public static XSSFSheet getDataSheet(String shname)
				{
					sheet=(XSSFSheet)wb1.getSheet(shname);
					
					return sheet;
				}
			
				
				
				public static Object[][] getTableArray(String sheetName) throws Exception
				{
					String [][] tabArray = null;
					
					ExcelWSheet=(XSSFSheet) wb1.getSheet(sheetName);
					int startRow=1;
					int startCol=0;
					int ci,cj;
					int totalRows=ExcelWSheet.getLastRowNum();
					System.out.println("No: of rows in excel: "+totalRows);
					
					//to fetch column count
					int totalCols=ExcelWSheet.getRow(0).getLastCellNum();
					System.out.println("No: of columns in excel: "+totalCols);
					
					tabArray=new String[totalRows][totalCols];
					
					ci=0;
					for(int i=startRow; i<=totalRows; i++,ci++)
						{
						cj=0;
						 for (int j=startCol;j<totalCols;j++, cj++)
						 {
							 
							    //tabArray[ci][cj]=getCellData(i,j);
							 tabArray[ci][cj]=formatter.formatCellValue(ExcelWSheet.getRow(i).getCell(j));
							 
							   // System.out.println(tabArray[ci][cj]); 
						 }
						 
						}
					return tabArray;
				}
				
				
				
				/*public static String getCellData(int RowNum, int ColNum) throws Exception {
					 
					 try{
					 
					 Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
					 
					// int dataType = Cell.getCellType();
					 
					// if  (dataType == 3) {
					 
					// return "";
					 
					// }else{
					 	
					 //String CellData =Cell.getStringCellValue();
					 return CellData;
					// }
					 }
					 catch (Exception e){
					 
					 System.out.println(e.getMessage());
					 
					 throw (e);
					 
					 }
					}*/
				
			

}

