package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber ) throws IOException {

        File file=new File(filepath);
        FileInputStream inputStream=new FileInputStream(file);
        XSSFWorkbook newWorkbook=new XSSFWorkbook(inputStream);
        XSSFSheet newSheet= newWorkbook.getSheet(sheetName);
        XSSFRow row= newSheet.getRow(rowNumber);
        XSSFCell cell= row.getCell(cellNumber);
        return cell.getStringCellValue();

    }

}
