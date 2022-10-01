package page;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static user_interfase.starc3_page.TestCasesSelect.SELECT_A_TEST_CASES;

@DefaultUrl("https://starc.grupohdi.com/starc3/Login")
public class Starc3Home extends PageObject {

    public int getNumOptionsCases(By locator){
        WaitUntil.the(locator,isClickable());
        $(locator).click();
        Select list = new Select($(locator));
        List <WebElement> listCase = list.getOptions();
        int num = listCase.size();
        System.out.println("Numero de casos: "+ num);
        return num;
    }



}
