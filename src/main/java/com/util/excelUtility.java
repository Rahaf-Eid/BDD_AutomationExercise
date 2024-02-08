package com.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class excelUtility {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public  excelUtility(String excelPath, String sheetName) {

        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + excelPath);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }
    public static int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public static String getCellData(int row, int column) {
        return sheet.getRow(row).getCell(column).getStringCellValue();
    }

    public static void getCellDataNumber(int row, int column) {
        double cellData = sheet.getRow(row).getCell(column).getNumericCellValue();
    }

}
