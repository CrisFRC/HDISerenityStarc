package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class ExcelRead {

    private static DecimalFormat ff = new DecimalFormat("####.##");

    public static String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber ) throws IOException {

        File file=new File(filepath);
        FileInputStream inputStream=new FileInputStream(file);
        XSSFWorkbook newWorkbook=new XSSFWorkbook(inputStream);
        XSSFSheet newSheet= newWorkbook.getSheet(sheetName);
        String type =newSheet.getRow(rowNumber).getCell(cellNumber).getCellType().name();
        XSSFRow row= newSheet.getRow(rowNumber);
        XSSFCell cell= row.getCell(cellNumber);
        if(type.equals("STRING")){
            return cell.getStringCellValue();
        }else if(type.equals("NUMERIC")){
            return String.valueOf(ff.format(cell.getNumericCellValue()));
        }else {
         return "0";
        }

    }






}
