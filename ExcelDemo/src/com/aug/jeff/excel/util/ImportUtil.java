package com.aug.jeff.excel.util;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ImportUtil {
    public static List<Properties> getProperties(Workbook wb, String sheetName, int headerRow, int startRow, DateFormat dateFormat,
            String curRowProperty, String... alertnateNames) throws Exception {
        List<Properties> propertiesList = new ArrayList<Properties>();
        Sheet sheet = wb.getSheet(sheetName);
        int blankLineCount = 0;
        int row = startRow;
        for (;; row++) {
            int col = 0;
            if (ExcelUtil.getCellValue(sheet, col, row) == null && ExcelUtil.getCellValue(sheet, col + 1, row) == null) {
                blankLineCount++;
                if (blankLineCount >= 5) {
                    break;
                }
            } else {
                Properties properties = new Properties();
                properties.put(curRowProperty, sheet + "!*" + ExcelUtil.getSSRow(row));

                for (col = 0;; col++) {
                    if (ExcelUtil.getCellValue(sheet, col, headerRow) == null) {
                        break;
                    }

                    String header = ExcelUtil.getCellValue(sheet, col, headerRow);
                    if (header == null || header.trim().length() == 0) {
                        break;
                    }

                    String value = null;
                    Cell cell = ExcelUtil.getCell(sheet, col, row);
                    if (cell != null && cell.getCellType() == Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                        Date date = DateUtil.getJavaDate(ExcelUtil.getCellDoubleValue(sheet, col, row));

                        value = dateFormat.format(date);
                    } else {
                        value = ExcelUtil.getCellValue(sheet, col, row);
                    }

                    if (value != null) {
                        properties.put(header, value);
                    }
                }

                propertiesList.add(properties);
                blankLineCount = 0;
            }
        }

        return propertiesList;
    }
}
