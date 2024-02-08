package com.util;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import excelUtility;
public class excelDataProvider {

    static int column;
    static int row;
    static excelUtility excel;

    @Test(dataProvider = "teatData")
    public static void registerUser(String Username, String Password) {


       // System.out.println(Username + "  " + Password);
    }

    @DataProvider(name = "teatData")
    public static Object[][] getData() {
        excel = new excelUtility("/Excel/Ctest.xlsx", "Sheet1");
        return testData();
    }

    public static Object[][] testData() {
        row = excel.getRowCount();
        column = excel.getColumnCount();
        //System.out.println(row + " " + column);
        Object data[][] = new Object[row - 1][column];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //System.out.println(excel.getCellData(i, j));
                data[i - 1][j] = (excel.getCellData(i, j));
            }
        }
        return data;
    }
}

