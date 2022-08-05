package tasks;

import jdk.internal.org.jline.utils.ShutdownHooks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import page.Starc3Home;
import utils.GetList;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static user_interfase.starc3_page.TestCasesProject.*;

public class GoOverScenery implements Task {


    Starc3Home starc;
    public static Performable go(){
        return  instrumented(GoOverScenery.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> listScenery = starc.sceneryList(SELECT_SCENARIO_LIST);
        GetList.sceneryList(listScenery);
    }
}
