package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import page.Starc3Home;
import questions.OverViewData;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static user_interfase.starc3_page.TestCasesSelect.*;


public class GoOverCases implements Task {

    private final String id_string;
    private final String generalBoxString;
    private final String generalOptionsString;

    Starc3Home starc3Home;

    public GoOverCases(String id_string, String generalBoxString, String generalOptionsString) {
        this.id_string = id_string;
        this.generalBoxString = generalBoxString;
        this.generalOptionsString = generalOptionsString;
    }

    public static Performable goCases(String id_string,String generalBoxString, String generalOptionsString){
        return instrumented(GoOverCases.class,id_string,generalBoxString,generalOptionsString);
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        int numCases =  starc3Home.getNumOptionsCases(SELECT_A_TEST_CASES);
        String defaultHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
        By GENERAL_BOX = By.xpath(generalBoxString);
        By OPTIONS = By.xpath(generalOptionsString);

        for(int j = 1; j<=numCases-1;j++) {
            System.out.println("caso:+++++++ "+j);
            actor.attemptsTo(
                    Switch.toActiveElement(),
                    WaitUntil.the(SELECT_A_TEST_CASES, isClickable()),
                    Click.on(SELECT_A_TEST_CASES),
                    Select.optionNumber(j).from(SELECT_A_TEST_CASES),
                    //condicion de aparicion caja de retirar tarjeta
                    Check.whether(OverViewData.BoxIsVisible(GENERAL_BOX))
                            .andIfSo(Scroll.to(GENERAL_BOX), //COLOCAR EL XPATH DEL CUADRO QUE SE VA A MODIFICAR
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
