package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static user_interfase.starc3_page.TestCasesProject.*;
import static user_interfase.starc3_page.TestCasesSelect.*;

public class OverViewData {

    public static Question<String> textScenery(){
        return actor -> BrowseTheWeb.as(actor).find(SELECT_SCENARIO_LIST).getSelectedVisibleTextValue();
    }

    public static Question<Boolean> RetiraIsVisible(){
        return actor -> BrowseTheWeb.as(actor).find(RETIRAR_TARJETA_BOX).isCurrentlyVisible();
    }


}
