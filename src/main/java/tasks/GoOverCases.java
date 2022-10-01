package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitOnSupplier;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitWithTimeout;
import page.Starc3Home;
import questions.OverViewData;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
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
        String defaultHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
        for(int j = 1; j<=numCases-1;j++) {
            System.out.println("caso:+++++++ "+j);
            actor.attemptsTo(
                    Switch.toActiveElement(),
                    WaitUntil.the(SELECT_A_TEST_CASES, isClickable()),
                    Click.on(SELECT_A_TEST_CASES),
                    Select.optionNumber(j).from(SELECT_A_TEST_CASES),
                    //condicion de aparicion caja de retirar tarjeta
                    Check.whether(OverViewData.RetiraIsVisible())
                            .andIfSo(Scroll.to(RETIRAR_RECIBO_BOX), //COLOCAR EL XPATH DEL CUADRO QUE SE VA A MODIFICAR
                                    Click.on(OPTIONS),
                                    WaitUntil.the(TEST_VALUES_OPTIONS,isVisible()).forNoMoreThan(5).seconds(),
                                    Click.on(TEST_VALUES_OPTIONS),
                                    WaitUntil.the(invisibilityOfElementLocated(TEST_VALUES_OPTIONS)), //recrea un tiempo de espera
                                    ChangeTestValues.test(id_string)),
                    Switch.toWindow(defaultHandle)

            );

        }



    }
}
