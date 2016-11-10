package com.aug.jeff.excel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.aug.jeff.excel.util.ExcelUtil;
import com.aug.jeff.excel.util.ImportUtil;

public class Test1 {

    private static Logger logger = Logger.getLogger(Test1.class);
    public static final int ROW_HEADER = ExcelUtil.getSSRow(3);
    public static final int ROW_DATASTART = ExcelUtil.getSSRow(3);
    public static final String EXCEL_ROW = "EXCEL_ROW";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static void main(String[] args) {
        try {
            File file = new File("resources/module_lazy_base.xls");
            String fileName = file.getName();
            logger.info("File Name: " + fileName);
            InputStream inputStream = new FileInputStream("resources/module_lazy_base.xls");
            Workbook wb = WorkbookFactory.create(inputStream);
            List<Properties> propertiesList;

            Sheet sheet = wb.getSheet("Custom Fields");
            Row row = sheet.getRow(2);
            Cell cell = row.getCell(0);
            System.out.println(cell.getRichStringCellValue());
            propertiesList = ImportUtil.getProperties(wb, "Custom Fields", ROW_HEADER, ROW_DATASTART, dateFormat, EXCEL_ROW);

            System.out.println(propertiesList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
