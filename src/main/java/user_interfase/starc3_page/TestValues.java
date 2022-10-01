package user_interfase.starc3_page;

import org.openqa.selenium.By;

public class TestValues {

    public static By TXT_OCR = By.xpath("//td[contains(text(),'|Valor_Compara') or contains(text(),'<IGNORE>')]");
    public static By TXT_OCR_INPUT = By.xpath("//textarea[@class='handsontableInput']");

    public static By SAVE_BUTTON = By.xpath("//button[text()='Salvar']");
}
