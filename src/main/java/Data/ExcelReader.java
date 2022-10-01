package Data;

import io.qameta.allure.internal.shadowed.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ExcelReader {

    public Object[][] read_sheet() throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        File myfile = new File(System.getProperty("user.dir") + "/src/main/java/Data/RegisterData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(myfile);
        XSSFSheet mysheet = wb.getSheet("Sheet1");
        int number_of_rows = mysheet.getPhysicalNumberOfRows();
        int number_of_columns = mysheet.getRow(0).getLastCellNum();
        String[][] myarray = new String[number_of_rows - 1][number_of_columns];
        for (int i = 1; i < number_of_rows; i++) {
            for (int a = 0; a < number_of_columns; a++) {
                XSSFRow row = mysheet.getRow(i);
                myarray[i - 1][a] = row.getCell(a).toString();
            }
        }
        return myarray;
    }
}