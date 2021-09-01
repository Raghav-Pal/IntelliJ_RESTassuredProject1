package ExcelUtils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReadWrite {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelReadWrite(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }

    public int getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of rows = " + rowCount);
        return  rowCount;
    }

    public void getCellData(int rowNum, int colNum) {

        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println("Cell Value is = " + value);
    }

}
















