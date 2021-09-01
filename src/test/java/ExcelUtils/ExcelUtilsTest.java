package ExcelUtils;

public class ExcelUtilsTest {


    public static void main(String[] args) {
        String excelPath = "./data/test_data.xlsx";
        String sheetName = "Sheet1";
        ExcelReadWrite excel = new ExcelReadWrite(excelPath,"Sheet1");

        int rowCount = excel.getRowCount();

        for(int rowNum = 1; rowNum < rowCount; rowNum++){
            for(int colNum=0; colNum<=1; colNum++) {
                excel.getCellData(rowNum, colNum);
            }
        }

    }

}
