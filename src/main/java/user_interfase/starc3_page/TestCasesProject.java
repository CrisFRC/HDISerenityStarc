package user_interfase.starc3_page;

import org.openqa.selenium.By;
import utils.GetXpath;

public class TestCasesProject {

    public static By MENU_SELECT = By.xpath( "//a[@role='button']" );
    public static By TEST_CASES_OPTION = By.cssSelector( "a[href='/starc3/Suite']" );
    public static By SELECT_PROJECT_LIST = By.xpath("//select[@id='cboSystem']/option[2]");

    public static By SELECT_SCENARIO_LIST =By.xpath( "//select[@ng-model='sc.selectedScenario']" );



}
