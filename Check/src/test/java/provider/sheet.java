package provider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class sheet {
	static int rowNo = 0;
	public static void initializeSheet()
	{
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+"\\results.xls");
			wb.createSheet("TrueTime Info");
			wb.write(fout);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void addData(List<String> data)
	{
		HSSFWorkbook wb = null;
		try {
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\results.xls");
			wb = new HSSFWorkbook(fin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet =  wb.getSheet("TrueTime Info");
		Row row;
		for(String value:data )
		{
			row = sheet.createRow(rowNo);
			Cell cellA = row.createCell(0);
			cellA.setCellValue(value);
			rowNo++;
		}
		rowNo++;
//		Cell cellA = row.createCell(0);
//		Cell cellB = row.createCell(1);
//		Cell cellC = row.createCell(2);
		
//		cellA.setCellValue(data.get(0));
//		cellB.setCellValue(data.get(1));
//		cellC.setCellValue(data.get(2));
		
		
		try {
			FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+"\\results.xls");
			System.out.println(System.getProperty("user.dir")+"\\results.xls");
			wb.write(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	public static void main(String[] args) {
//		initializeSheet();
//		List<String> ls = new ArrayList<String>();
//		ls.add("A");
//		ls.add("B");
//		addData(ls);
//		ls.clear();
//		ls.add("C");
//		ls.add("E");
//		
//		addData(ls);
//		addData(ls);
//	}


}
