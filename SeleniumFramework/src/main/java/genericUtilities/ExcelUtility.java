package genericUtilities;

import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility implements IAutoConstantsUtility {
	Workbook wb;
	@DataProvider(name ="excel")
	public Object[][] readData()
	{
		
		File f=new File(EXCEL_PATH);
		try {
			wb=WorkbookFactory.create(f);
		} catch (EncryptedDocumentException e) {			
			e.printStackTrace();
		} catch (InvalidFormatException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowcount);
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();	
		System.out.println(cellcount);
		Object[][] data=new Object[rowcount][cellcount];
		for(int r=0;r<rowcount;r++)
		{
			Row activerow = sheet.getRow(r);
			for(int c=0;c<activerow.getPhysicalNumberOfCells();c++)
			{
				data[r][c]=activerow.getCell(c).toString();
						
			}
		}
		return data;
		
	}
	 

}
