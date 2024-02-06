package genericLibraries;
/*
 * This class contains methods to perform actions on an excel file
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;	
public class ExcelFileUtility {
	FileInputStream fis;
	FileOutputStream fos;
	Workbook workbook;
	
	DataFormatter df;
	/*
	 * This method is used to initialize an excel file
	 * @param excelpath;
	 */
	public void excelInitialization(String excelpath)
	{
		try {
			fis=new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		   workbook=WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	/*
	 * This method is used to fetch single data from excel
	 * @param shhetname
	 * @param rownum
	 * @param cellnum
	 */
	public String getSingleDataFromExcel(String sheetname,int rownum,int cellnum)
	{
		df=new DataFormatter();
		Sheet sheet=workbook.getSheet(sheetname);
		return df.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
	}
	/*
	 * This method is used to fetch multiple data from excel
	 * @param sheetname
	 * @param expectedTestCase
	 */
	
	
	   public Map<String, String> getDataBasedOnKey(String sheetname, String expectedTestCase) 
	   {
	    df = new DataFormatter();
	    Map<String, String> map = new HashMap<>();
	    Sheet sheet = workbook.getSheet(sheetname);
	    
	    System.out.println("Expected Test Case: " + expectedTestCase);
	    
	    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
	        String currentTestCase = df.formatCellValue(sheet.getRow(i).getCell(1));
	        //System.out.println("Current Test Case: " + currentTestCase);

	        if (currentTestCase.equalsIgnoreCase(expectedTestCase)) {
	          //System.out.println("Found expected test case: " + expectedTestCase);
	            for (int j = i; j <=sheet.getLastRowNum(); j++) {
	                String key = df.formatCellValue(sheet.getRow(j).getCell(2));
	                String value = df.formatCellValue(sheet.getRow(j).getCell(3));
	                map.put(key, value);
	                if (key.equals("####")) {
	                   System.out.println("Reached end of data section");
	                    break;
	                }
	            }
	            break;
	        }
	    }
	    
	    System.out.println("Final Map: " + map);
	    return map;
	}
	   /*
	    * This method is used to fetch multiple values for single key
	    */
	   public Map<String, List<String>> getMultipleDataBasedOnKey(String sheetname, String expectedTestCase) {
		    df = new DataFormatter();
		    Map<String, List<String>> map = new HashMap<>();
		    Sheet sheet = workbook.getSheet(sheetname);

		    System.out.println("Expected Test Case: " + expectedTestCase);

		    List<String> currentValues = null;

		    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		        String currentTestCase = df.formatCellValue(sheet.getRow(i).getCell(1));

		        if (currentTestCase.equalsIgnoreCase(expectedTestCase)) {
		            currentValues = new ArrayList<>();

		            for (int j = i + 1; j <= sheet.getLastRowNum(); j++) {
		                String key = df.formatCellValue(sheet.getRow(j).getCell(2));

		                if (key.equals("####")) {
		                    System.out.println("Reached end of data section");
		                    break;
		                }

		                String value = df.formatCellValue(sheet.getRow(j).getCell(3));
		                currentValues.add(value);
		            }

		            map.put(expectedTestCase, currentValues);
		        }
		    }

		    System.out.println("Final Map: " + map);
		    return map;
		}

	
	   /*
		 * This method is used to update Single cell in excel
		 * @param sheetname
		 * @param status
		 * @param expectedTestCase
		 * @param excelpath
		 */
		
		   public void updateSingleCellInExcel(String sheetname, String expectedTestCase, String status, String excelpath)
		   {
		    df = new DataFormatter();
		    Sheet sheet = workbook.getSheet(sheetname);
		    
		    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		        String currentTestCase = df.formatCellValue(sheet.getRow(i).getCell(1));
		       // System.out.println("Current Test Case: " + currentTestCase);

		        if (currentTestCase.equalsIgnoreCase(expectedTestCase)) {
		            //System.out.println("Found expected test case: " + expectedTestCase);
		            Cell cell = sheet.getRow(i).createCell(4);
		            cell.setCellValue(status);
		            break;
		        }
		    }

		    try {
		        fos = new FileOutputStream(excelpath);
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }

		    try {
		        workbook.write(fos);
		        System.out.println("Workbook written to file.");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    try {
		        fos.flush();
		        System.out.println("File output stream flushed.");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		  
	/*
	 * This method is to close the workbook
	 */
	public void closeExcel()
	{
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
	