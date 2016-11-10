package com.aug.jeff.excel.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.aug.jeff.excel.exception.ExcelException;

public class ExcelUtil {

    public static String getCellValue(Sheet sheet, int colNum, int rowNum) throws ExcelException {
        Cell cell = getCell(sheet, colNum, rowNum);
        if (null == cell) {
            return null;
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return null;
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return Boolean.toString(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
                return Double.toString(cell.getNumericCellValue());
            } else {
                return Double.toString(cell.getNumericCellValue());
            }
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return cell.getCellFormula();
        } else {
            throw new ExcelException("Unsupported cell type " + cell.getCellType() + " @ " + sheet.getSheetName() + "!");
        }
    }

    /**
     * Get the specific cell
     * @param sheet the cell include sheet
     * @param colNum the cell in which column
     * @param rowNum the cell in which row
     * @return
     */
    public static Cell getCell(Sheet sheet, int colNum, int rowNum) {
        Row row = sheet.getRow(rowNum);
        if (null == row) {
            return null;
        }
        Cell cell = row.getCell(colNum);
        return cell;
    }

    /**
     * Get row from Excel row
     */
    public static int getSSRow(int rowNum) {
        return rowNum - 1;
    }
    
    /**
     * Get Cell value as double at the x,y coordinate.
     */
    public static double getCellDoubleValue (Sheet sheet, int colNum, int rowNum) throws ExcelException {
       Cell cell = getCell(sheet, colNum, rowNum);

       if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
          return 0.0;
       }
       else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
          return cell.getNumericCellValue();
       }
       else {
           throw new ExcelException("Get number from cell type "+cell.getCellType()+" not supported @ "+sheet.getSheetName()+"!"+ExcelUtil.getCellReference(colNum, rowNum));
       }
    }
    
    /**
     * Get Cell reference
     */
     public static String getCellReference(int col, int row) {
       return ExcelUtil.getExcelColumn(col)+ExcelUtil.getExcelRow(row);
     }
     
     /**
      * Get Excel column (e.g. "AZ") from  column
      */
     public static String getExcelColumn (int colNum) {
        String column = "";

        char msb = (char) (colNum/26);

        if (msb != 0) {
          msb--;
          msb += 'A';
          column += msb;
        }

        char lsb = (char) (colNum%26);
        lsb += 'A';
        column += lsb;

        return column;
     }
     
     /**
      * Get Excel row from  column
      */
     public static int getExcelRow (int row) {
        return row+1;
     }
}
