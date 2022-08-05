package stepdefinitions.starc;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tasks.*;
import utils.GetConfig;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ChangeIdRetirarTarjetaStepDefinitions {



    @Before
    public void initialSetup() {
        setTheStage(new OnlineCast());
    }

    @Given("^(.*) is login on starc page")
    public void the_user_is_login_on_starc_page(String actor) {
        setTheStage(new OnlineCast());
        OnStage.theActorCalled(actor).attemptsTo(
                NavigateToStarc3Home.Starc3Home(),
                DoLoginStarc.withCredentials(GetConfig.CONFIGS.getString("user.starc"), GetConfig.CONFIGS.getString("password.starc")),
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
    public void user_change_id_of_withdraw_card_por_each_scenery_in(String string) {
        theActorInTheSpotlight().attemptsTo(
                GoOverScenery.go()
        );

    }
    @Then("id could be change")
    public void id_could_be_change() {

    }

}
