package JUnitTest;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TestsJunit {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;


    @Test
    public void automationIdUpdate(){



    }

}
