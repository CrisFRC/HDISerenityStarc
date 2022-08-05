package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import utils.GetXpath;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static user_interfase.starc3_page.TestCasesProject.*;

public class GoingToTestCases implements Task {

    private final String numR;

    public GoingToTestCases(String numR) {
        this.numR = numR;
    }

    public static Performable goingTo(String numR){
        return instrumented(GoingToTestCases.class,numR);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        By SELECT_REQUIREMENT_LIST = By.xpath(GetXpath.buildXpath(numR));
        actor.attemptsTo(
//                WaitUntil.the(MENU_SELECT,isVisible()),
                Click.on(MENU_SELECT),
                Click.on(TEST_CASES_OPTION),
                WaitUntil.the(SELECT_PROJECT_LIST,isClickable()),
                Click.on(SELECT_PROJECT_LIST),
                Click.on(SELECT_REQUIREMENT_LIST),
                Click.on(SELECT_SCENARIO_LIST)
                );
    }
}
