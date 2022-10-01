package stepdefinitions.starc.hyo;


import io.cucumber.java.en.When;
import tasks.*;
import utils.GetConfig;
import utils.GetList;
import java.io.IOException;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ChangeStateRetirarReciboStepDefinitions {


    @When("user change value of print box por each scenery in {string}")
    public void user_change_id_of_withdraw_card_por_each_scenery_in(String path) throws IOException {

        String box = String.format(GetConfig.CONFIGS.getString("GENERAL.BOX"),"Retirar Recibo");
        String options = String.format(GetConfig.CONFIGS.getString("OPTIONS.GENERAL"),"Retirar Recibo");
        List<List<String>> list = GetList.sceneryList(path);
        for(int i = 0; i<= list.get(0).size()-1;i++) {
            if (list.get(2).get(i).equals("SI")) {
                String id_change = GetConfig.CONFIGS.getString("OCR.txt.retirar.recibo");
                theActorInTheSpotlight().attemptsTo(
                        GoOverScenery.go(list.get(0).get(i)),
                        GoOverCases.goCases(id_change,box,options)
                );
            }
        }
    }

}
