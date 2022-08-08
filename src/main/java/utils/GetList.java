package utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class GetList {



    public static List<List<String>>  sceneryList(String path) throws IOException {

        List<List<String>> list = new ArrayList<List<String>>();
        String numScenery = GetConfig.CONFIGS.getString("excel.totalScenery");
        String sheetName = GetConfig.CONFIGS.getString("excel.sheetName");
        int num = Integer.parseInt(numScenery);
        String cellValue=" ";
        for (int k =0; k <= 3;k++ ){
            list.add(new ArrayList<String>());
        }
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <= 3; j++) {
                cellValue = ExcelRead.getCellValue(path, sheetName, i, j);
                list.get(j).add(cellValue);
                }
            }
        return list;

        }

    /**
     *
     * Using Selenium in this part
     * @param dropdownList = list web element
     * @return number of options
     */
    public static  int getNumOptionsCases(By dropdownList){

//        Select list = new Select(driver.findElement(dropdownList));
        return 0;
    }


}


