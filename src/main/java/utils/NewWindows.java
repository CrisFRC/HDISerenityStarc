package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class NewWindows {

    public static String getNewWindowHandle(Actor actor, String currentWindowHandle){
        for(String windowHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()){
            if(!windowHandle.equals(currentWindowHandle)){
                System.out.println("+++++++++++++++++++++++ "+windowHandle);
                return windowHandle;
            }
        }
        return null;
    }
}
