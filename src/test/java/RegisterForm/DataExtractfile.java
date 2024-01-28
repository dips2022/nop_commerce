package RegisterForm;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataExtractfile {
	public Object[][] getdatafromexcel() throws EncryptedDocumentException, IOException {

		// reading our Excel file through FileInputStream

		FileInputStream fis = new FileInputStream("C:\\sts\\Project1\\src\\main\\resources\\Projectfiledata.xlsx");

		Workbook book = WorkbookFactory.create(fis);

		Sheet sh = book.getSheet("Sheet1");

		// get last row number and last coloumn

		short cellsize = sh.getRow(0).getLastCellNum();

		int rowcount = sh.getLastRowNum();

		Object[][] obj = new Object[rowcount][cellsize];

		// Here 2 loops are used so that first we keep the row value same and iterate
		// over coloums and do the same for all the rows

		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < cellsize; j++) {
				obj[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
//        System.out.println("OBJ"+obj);
		return obj;
		

	}

}



