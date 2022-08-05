package page;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://starc.grupohdi.com/starc3/Login")
public class Starc3Home extends PageObject {

    public List<String> sceneryListElements;
    public List<String> sceneryList(By webList){
        sceneryListElements = $(webList).getSelectedValues();
        return sceneryListElements;
    }


}
