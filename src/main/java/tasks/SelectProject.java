package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static user_interfase.starc3_page.MenuProject.*;

public class SelectProject implements Task {


    public static Performable select(){
        return  instrumented(SelectProject.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(SELECT_PROJECT_LIST,isClickable()),
                Click.on(SELECT_PROJECT_LIST),
                Click.on(OK_BUTTON)
        );
    }
}
