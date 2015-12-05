package com.aug.jeff.excel.testinline;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.aug.jeff.excel.util.ExcelUtil;

public class Test1 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("resources/module_lazy_base.xls");
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheet("Custom Fields");
            int rowNum = 2; // start with 0
            System.out.println(ExcelUtil.getCellValue(sheet, 0, rowNum));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
