package com.selenium.datadriven.fileread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void main(String[] args) throws Exception {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employee Details");

		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		for (int i = 0; i < 10; i++) {
			LinkedHashMap<Object, Object> mMap = new LinkedHashMap<Object, Object>();
			mMap.put("EmployeeName", "Emp : " + i);
			mMap.put("Age", i);
			mMap.put("birthDay", "Bday"+i);
			list.add(mMap);
		}
		


		// Row headerRow = sheet.createRow(0);

		int rowNum = 1;
		System.out.println("Creating excel");

		Iterator iterator = list.get(0).keySet().iterator();
		Row headerRow = sheet.createRow(0);
		int HeaderColNumber = 0;
		while (iterator.hasNext()) {
			Cell header = headerRow.createCell(HeaderColNumber++);
			header.setCellValue(iterator.next().toString());
		}

		for (Map<Object, Object> temp : list) {

			Iterator it = temp.keySet().iterator();
			int colNum = 0;
			Row row = sheet.createRow(rowNum++);
			while (it.hasNext()) {
				Object key = temp.get(it.next());
				Cell cell = row.createCell(colNum++);
				if (key instanceof String) {
					cell.setCellValue((String) key);
				}
				if (key instanceof Integer) {
					cell.setCellValue((Integer) key);
				}
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream("/Users/admin/Desktop/Workbook1.xlsx");
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}

}
