
/**
 * @author D E L L
 *
 */
package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String XLSHEETPATH="C:\\Shruti\\Study\\Selenium\\Itelearn Karthik Selenium\\Practise Programs\\Git Project with Smriti\\freeCRMMaven\\src\\main\\java\\com\\crm\\qa\\testData\\freeCRMMavenData.xlsx";
	static Workbook wrkBookObj;
	static Sheet sheetObj;
	int xlRow,xlCol;
	
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public Object[][] readXLData(String sheetName) {
		File fileObj=new File(XLSHEETPATH);
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(fileObj);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wrkBookObj=WorkbookFactory.create(fis);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheetObj=wrkBookObj.getSheet(sheetName);
		xlRow=sheetObj.getLastRowNum();
		xlCol=sheetObj.getRow(0).getLastCellNum();
		//empty array created with row and column specified
		Object[][] xlDataArr=new Object[xlRow][xlCol];
		
		//filling array object: ISSUE: NOT FILLING LAST ROW
		for (int i=0;i<xlRow;i++) {
			for (int j=0;j<xlCol;j++) {
				xlDataArr[i][j]=sheetObj.getRow(i+1).getCell(j).toString();
				System.out.println("data " + i + ":" + j + "is: "+xlDataArr[i][j]);
			}
		}
		return xlDataArr;
	}
}