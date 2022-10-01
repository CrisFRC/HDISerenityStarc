package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/change_state_retirar_recibo_hyo.feature",
        glue ="stepdefinitions.starc",
        tags ="@RetirarRecibo")
public class ChangeValueRetirarReciboRunner {
}
