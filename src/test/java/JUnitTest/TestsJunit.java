package JUnitTest;



import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class TestsJunit {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;


//    Starc3TestSuite starc3TestSuite;

    @Test
    public void selectList(){
//        starc3TestSuite.open();
//        assertThat(starc3TestSuite.selectEsc()).isEmpty();
    }

}
