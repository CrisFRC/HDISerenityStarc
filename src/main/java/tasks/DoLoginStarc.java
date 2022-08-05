package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static user_interfase.starc3_page.Loggin.*;

public class DoLoginStarc implements Task {

    private final String user;

    private final String password;


    public DoLoginStarc(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Performable withCredentials(String user, String password){
        return instrumented(DoLoginStarc.class,user,password);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(USERNAME_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),
                Click.on(LOGIN_BUTTON)
        );

    }
}
