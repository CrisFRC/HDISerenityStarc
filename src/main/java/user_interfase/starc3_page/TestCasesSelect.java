package user_interfase.starc3_page;

import org.openqa.selenium.By;

public class TestCasesSelect {

    public static By SELECT_A_TEST_CASES = By.cssSelector( "select[ng-model='sc.selectedSuite']" );
    public static By SAVE_BUTTON = By.xpath( "//button[text()='Save']" );
//    public static By RETIRAR_TARJETA_BOX = By.xpath("//b[text()='Retirar Tarjeta']");
//    public static By RETIRAR_RECIBO_BOX = By.xpath("//b[text()='Retirar Recibo']");
//    public static By CONFIG_ROBOT_BOX = By.xpath("//b[text()='Iniciar Configuracion Robot']");

    public static By TEST_VALUES_OPTIONS = By.cssSelector( "a[ng-click='openTestValues()']" );

    //------------------ 3 points options --------------------------------------------------
    //public static By OPTIONS_RR = By.xpath("//li[@name='Retirar Recibo']//child::span[@style='cursor:pointer']");



}
