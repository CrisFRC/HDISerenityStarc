package stepdefinitions.starc.multivendor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;
import tasks.*;
import utils.GetConfig;
import utils.GetList;

import java.io.IOException;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ChangeConfigRobotMultivendorStepDefinitions {

    @Before
    public void initialSetup() {
        setTheStage(new OnlineCast());
    }

    @Given("^(.*) is login on starc page")
    public void user_is_login_on_starc_page(String actor) {
        String userName =GetConfig.CONFIGS.getString("user.starc");
        String pass =  GetConfig.CONFIGS.getString("password.starc");
        setTheStage(new OnlineCast());
        OnStage.theActorCalled(actor).attemptsTo(
                NavigateToStarc3Home.Starc3Home(),
                DoLoginStarc.withCredentials(userName,pass),
                SelectProject.select()
        );
    }
    @And("he select request {word}  on test cases screen")
    public void he_select_request_on_test_cases_screen(String  numR) {
        theActorInTheSpotlight().attemptsTo(
                GoingToTestCases.goingTo(numR)
        );
    }



    @When("user change value of config box for each scenery in {string}")
    public void user_change_value_of_config_box_for_each_scenery_in(String path) throws IOException {

        String box = String.format(GetConfig.CONFIGS.getString("GENERAL.BOX"),"Iniciar Configuracion Robot");
        String options = String.format(GetConfig.CONFIGS.getString("OPTIONS.GENERAL"),"Iniciar Configuracion Robot");
        List<List<String>> list = GetList.sceneryList(path);
        for(int i = 0; i<= list.get(0).size()-1;i++) {
            if (list.get(2).get(i).equals("SI")) {
                String id_change = String.format(GetConfig.CONFIGS.getString("txt.config.robot"),list.get(3).get(i));;
                theActorInTheSpotlight().attemptsTo(
                        GoOverScenery.go(list.get(0).get(i)),
                        GoOverCases.goCases(id_change,box,options)
                );
            }
        }
    }
}
