package stepdefinitions.starc;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import questions.OverViewData;
import tasks.*;
import utils.ExcelRead;
import utils.GetConfig;
import utils.GetList;

import java.io.IOException;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChangeIdRetirarTarjetaStepDefinitions {



    @Before
    public void initialSetup() {
        setTheStage(new OnlineCast());
    }

    @Given("^(.*) is login on starc page")
    public void the_user_is_login_on_starc_page(String actor) {
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
    public void he_is_on_test_cases_screen(String numR) {
        theActorInTheSpotlight().attemptsTo(
                GoingToTestCases.goingTo(numR)
        );

    }
    @When("user change id of withdraw card por each scenery in {string}")
    public void user_change_id_of_withdraw_card_por_each_scenery_in(String path) throws IOException {
            List<List<String>> list = GetList.sceneryList(path);
            for(int i = 0; i<= list.get(0).size()-1;i++) {
                if (list.get(2).get(i).equals("SI")) {
                    theActorInTheSpotlight().attemptsTo(
                            GoOverScenery.go(list.get(0).get(i)),
                            GoOverCases.goCases()
                    );
                }
            }
    }
    @Then("id could be change")
    public void id_could_be_change() {
//        theActorInTheSpotlight().should(
//                seeThat("the text of scenery selected", OverViewData.textScenery(),equalTo("(851498) Escenario001.Retiro Cuenta Ahorros y Corriente_E2E"))
//        );
    }

}
