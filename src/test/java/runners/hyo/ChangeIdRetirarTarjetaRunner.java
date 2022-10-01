package runners.hyo;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/change_id_retirar_tarjeta_hyo.feature",
glue ="stepdefinitions.starc.hyo",
tags ="@Hyowithpayments")
public class ChangeIdRetirarTarjetaRunner {
}
