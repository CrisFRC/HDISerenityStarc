package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static user_interfase.starc3_page.TestCasesProject.SELECT_SCENARIO_LIST;


public class GoOverScenery implements Task {

    private final  String esc;

    public GoOverScenery(String esc) {
        this.esc = esc;
    }


    public static Performable go(String esc){
        return  instrumented(GoOverScenery.class, esc);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

           actor.attemptsTo(
                WaitUntil.the(SELECT_SCENARIO_LIST,isClickable()),
//                Click.on(SELECT_SCENARIO_LIST),
                Select.value(esc).from(SELECT_SCENARIO_LIST)
           );

    }
}
