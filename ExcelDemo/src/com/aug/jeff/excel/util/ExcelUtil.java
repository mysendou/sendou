package com.aug.jeff.excel.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.aug.jeff.excel.exception.ExcelException;

public class ExcelUtil {
    public static Object getCellValue(Sheet sheet, int colNum, int rowNum) throws ExcelException {
        Cell cell = getCell(sheet, colNum, rowNum);
        if(null == cell){
            return null;
        } else if(cell.getCellType() == Cell.CELL_TYPE_STRING){
            return cell.getRichStringCellValue();
        } else if(cell.getCellType() == Cell.CELL_TYPE_BLANK){
            return null;
        } else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
            return cell.getBooleanCellValue();
        } else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue();
            }
            else {
                return cell.getNumericCellValue();
            }
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return cell.getCellFormula();
        } else {
            throw new ExcelException("Unsupported cell type "+cell.getCellType()+" @ "+sheet.getSheetName()+"!");
        }
    }

    public static Cell getCell(Sheet sheet, int colNum, int rowNum) {
        Row row = sheet.getRow(rowNum);
        if (null == row) {
            return null;
        }
        Cell cell = row.getCell(colNum);
        return cell;
    }
}
