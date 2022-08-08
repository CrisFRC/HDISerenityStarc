package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import page.Starc3Home;
import questions.OverViewData;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static user_interfase.starc3_page.TestCasesSelect.*;
import static user_interfase.starc3_page.TestValues.*;


public class GoOverCases implements Task {

    private final String id_string;

    Starc3Home starc3Home;

    public GoOverCases(String id_string) {
        this.id_string = id_string;
    }

    public static Performable goCases(String id_string){
        return instrumented(GoOverCases.class,id_string);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int numCases =  starc3Home.getNumOptionsCases(SELECT_A_TEST_CASES);
        for(int j = 1; j<=numCases-1;j++) {
            actor.attemptsTo(
                    WaitUntil.the(SELECT_A_TEST_CASES, isClickable()),
                    Click.on(SELECT_A_TEST_CASES),
                    Select.optionNumber(j).from(SELECT_A_TEST_CASES),
                    //condicion de aparicion caja de retirar tarjeta
                    Check.whether(OverViewData.RetiraIsVisible())
                            .andIfSo(Scroll.to(RETIRAR_TARJETA_BOX),
                                    Click.on(OPTIONS),
                                    WaitUntil.the(TEST_VALUES_OPTIONS,isVisible()),
                                    Click.on(TEST_VALUES_OPTIONS),
                                    ChangeTestValues.test(id_string))
            );
        }



    }
}
