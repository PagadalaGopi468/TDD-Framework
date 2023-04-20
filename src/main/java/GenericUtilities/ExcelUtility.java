package GenericUtilities;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
    import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelUtility {
		
		InstanceUtility i=new InstanceUtility();
		public String ReadData(String sheet,int rowno,int cellno)throws Exception
		{
			FileInputStream f=new FileInputStream(i.ExcelPath());
			Workbook wb = WorkbookFactory.create(f);
			Sheet sh = wb.getSheet(sheet);
			Row r = sh.getRow(rowno);
			Cell c = r.getCell(cellno);
			String value = c.getStringCellValue();
			return value;
		}
		
		public void WriteDataIntoExcel(String sheet,int rowno,int cellno,String value) throws Exception
		{
			FileInputStream f=new FileInputStream(i.ExcelPath());
			Workbook wb = WorkbookFactory.create(f);
			Sheet sh = wb.getSheet(sheet);
			Row r = sh.getRow(rowno);
			Cell c = r.createCell(cellno);
			c.setCellValue(value);
			
			FileOutputStream fo=new FileOutputStream(i.ExcelPath());
			wb.write(fo);
			wb.close();
		}
		
		public int getrowcount(String sheet) throws Exception
		{
			FileInputStream f=new FileInputStream(i.ExcelPath());
			Workbook wb = WorkbookFactory.create(f);
			Sheet sh = wb.getSheet(sheet);
			int count = sh.getLastRowNum();
			return count;
		}
				
		public Object[][] ReadMultipledataFromExcel(String SheetName) throws Exception
		{
		FileInputStream f=new FileInputStream(i.ExcelPath());
		Workbook book = WorkbookFactory.create(f);
		Sheet sh = book.getSheet(SheetName);

		int lastRow = sh.getLastRowNum();
		short lastCell = sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<=lastRow;i++)
		{
			for(int j=0;j<=lastCell;j++)
			{
				data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
		}
}
