package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static user_interfase.starc3_page.TestCasesProject.SELECT_SCENARIO_LIST;

public class OverViewData {

    public static Question<String> textScenery(){
        return actor -> BrowseTheWeb.as(actor).find(SELECT_SCENARIO_LIST).getSelectedVisibleTextValue();
    }


}
