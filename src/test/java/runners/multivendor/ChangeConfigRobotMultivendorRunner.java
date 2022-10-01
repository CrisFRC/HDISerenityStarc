package runners.multivendor;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/change_id_config_robot_mltvendor.feature",
        glue ="stepdefinitions.starc.multivendor",
        tags ="@MultivendorConfigRobot")
public class ChangeConfigRobotMultivendorRunner {
}
