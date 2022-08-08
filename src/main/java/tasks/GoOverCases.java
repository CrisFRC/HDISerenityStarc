package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import page.Starc3Home;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static user_interfase.starc3_page.TestCasesSelect.*;


public class GoOverCases implements Task {


    public static Performable goCases(){
        return instrumented(GoOverCases.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SELECT_A_TEST_CASES,isClickable()),
                Click.on(SELECT_A_TEST_CASES),
                Select.optionNumber(1).from(SELECT_A_TEST_CASES)
        );
    }
}
