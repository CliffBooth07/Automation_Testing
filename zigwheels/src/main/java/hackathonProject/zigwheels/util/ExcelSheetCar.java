package hackathonProject.zigwheels.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelSheetCar {

	public static void intializeSheet() {
		FileInputStream fin;
		HSSFWorkbook wb=null;
		try {
			fin = new FileInputStream(System.getProperty("user.dir")+"\\results.xls");
			wb = new HSSFWorkbook(fin);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			wb.createSheet("Car Info");

			FileOutputStream fout = new FileOutputStream(
					System.getProperty("user.dir")+"\\results.xls");
			wb.write(fout);
			wb.close();
		} catch (Exception e) {
		}
	}

	public static void addData(List<String> data, int i) {
		HSSFWorkbook wb = null;
		try {
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\results.xls");
			wb = new HSSFWorkbook(fin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet("Car Info");
		Row row = sheet.createRow(i);
		Cell cellA = row.createCell(0);
//		Cell cellC = row.createCell(2);

		cellA.setCellValue(data.get(0));
//		cellB.setCellValue(data.get(1));
//		cellC.setCellValue(data.get(2));

		try {
			FileOutputStream fout = new FileOutputStream(
					System.getProperty("user.dir")+"\\results.xls");
			wb.write(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
