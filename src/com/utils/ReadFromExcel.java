package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

    private Sheet excelSheet;

    public ReadFromExcel(String fileName, String sheetName) {

        initWorkBook(fileName, sheetName);
    }

    private void initWorkBook(String fileName, String sheetName) {

        File excelFile = new File(fileName);
        Workbook myWorkBook = null;
        try {
            // Finds the workbook instance for XLSX file
            myWorkBook = WorkbookFactory.create(excelFile);

            // Get the sheet from the XLSX workbook form sheet name
            excelSheet = myWorkBook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } finally {

            if (myWorkBook != null) {
                try {
                    myWorkBook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Object[][] getSheetData() {

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = excelSheet.iterator();

        int colCount = excelSheet.getRow(0).getPhysicalNumberOfCells();
        int rowCount = excelSheet.getPhysicalNumberOfRows() - 1;

        Object[][] tabArray = new Object[rowCount][colCount];
        boolean isHeaderRow = true;
        int rowIndex = 0;
        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (isHeaderRow) {
                isHeaderRow = false;
                continue;
            }
            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            for (int colIndex = 0; cellIterator.hasNext(); colIndex++) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        tabArray[rowIndex][colIndex] = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        tabArray[rowIndex][colIndex] = cell.getNumericCellValue();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        tabArray[rowIndex][colIndex] = cell.getBooleanCellValue();
                        break;
                    default:
                        tabArray[rowIndex][colIndex] = null;
                }
            }
            rowIndex++;

        }
        
        return tabArray;
    }

}
