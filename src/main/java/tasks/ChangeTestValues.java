package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import user_interfase.starc3_page.TestValues;
import utils.NewWindows;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static user_interfase.starc3_page.TestCasesSelect.*;
import static user_interfase.starc3_page.TestValues.*;
import static user_interfase.starc3_page.TestValues.SAVE_BUTTON;

public class ChangeTestValues implements Task {

    private final String id_string;

    public ChangeTestValues(String id_string) {
        this.id_string = id_string;
    }

    public static Performable test(String id_string){
        return instrumented(ChangeTestValues.class,id_string);
    }


    public static String getNewWindowHandle(Actor actor, String currentWindowHandle){
        for(String windowHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()){
            if(!windowHandle.equals(currentWindowHandle)){
                System.out.println("+++++++++++++++++++++++ "+windowHandle);
                return windowHandle;
            }
        }
        return null;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        String currentHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
        actor.attemptsTo(
//                Switch.toWindow("Test Values - Gooogle Chrome"),
                Switch.toWindow(getNewWindowHandle(actor,currentHandle)),
                WaitUntil.the(TXT_OCR,isClickable()),
                DoubleClick.on(TXT_OCR),
                Enter.theValue(id_string).into(TXT_OCR),
                Click.on(SAVE_BUTTON)
        );

    }
}
