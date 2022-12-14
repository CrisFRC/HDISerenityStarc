package tasks;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;


import java.awt.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
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
//                System.out.println("+++++++++++++++++++++++ "+windowHandle);
                return windowHandle;
            }
        }
        return null;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {


        

    }
}
