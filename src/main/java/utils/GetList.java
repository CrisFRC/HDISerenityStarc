package utils;

import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GetList {


    public static void sceneryList(List<String> list){
        for(String str: list){
            System.out.println("+++++++++++++++++++++++"+str);
        }


    }

}
