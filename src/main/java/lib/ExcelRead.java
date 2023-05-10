package lib;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {
    Sheet sh;


    public ExcelRead(String filename, String sheetname) throws IOException {

        FileInputStream fis = new FileInputStream(filename);
        Workbook wb = new XSSFWorkbook(fis);
        sh = wb.getSheet(sheetname);

    }

    public Object[][] excelToArray() {
        Object[][] t;


        int totalRows = sh.getPhysicalNumberOfRows();
        int totalCols = sh.getRow(0).getPhysicalNumberOfCells();
        t = new Object[totalRows - 1][totalCols];

        //read excel cell value & store value

        for (int r = 1; r < totalRows; r = r + 1) {

            for (int col = 0; col < totalCols; col = col + 1) {
                //read each cell & store into arrays position
                //t[r-1][c]     =read excel r:1 c:0
                t[r - 1][col] = getCellData(r, col);

            }
        }
        return t;
    }

    public String getCellData(int row, int col) {

        Cell c = sh.getRow(row).getCell(col);

        String value ="";


        if (c.getCellType() == Cell.CELL_TYPE_STRING) {
            //String
             value = c.getStringCellValue();


        } else {
            //numeric area:
            if (c.getNumericCellValue() % 1 == 0) {
                //numeric : int
                 value =""+ (int) c.getNumericCellValue();
               
            } else {
                //double
                 value =""+ c.getNumericCellValue();

            }

        }
        return value;


    }
}




















