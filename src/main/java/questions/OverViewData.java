package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import static user_interfase.starc3_page.TestCasesProject.*;

public class OverViewData {



    public static Question<String> textScenery(){
        return actor -> BrowseTheWeb.as(actor).find(SELECT_SCENARIO_LIST).getSelectedVisibleTextValue();
    }

    public static Question<Boolean> BoxIsVisible(By BOX_GENERAL){
//        return actor -> BrowseTheWeb.as(actor).find(RETIRAR_TARJETA_BOX).isCurrentlyVisible();
        return actor -> BrowseTheWeb.as(actor).find(BOX_GENERAL).isCurrentlyVisible();
    }

    public static Question<Boolean> OcrIsVisible(String path){
        By BOX_GENERAL = By.xpath(path);
        return actor -> BrowseTheWeb.as(actor).find(BOX_GENERAL).isCurrentlyVisible();
    }


}
