package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import page.Starc3Home;

public class NavigateToStarc3Home {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;
    public static Performable Starc3Home() {
        return Task.where("{0} opens the starc 3 home page",
                Open.browserOn().the(Starc3Home.class));
    }
}
