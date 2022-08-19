package elements.account;

import elements.BaseElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2
public class LightningInputAccount extends BaseElement {

    private final static String INPUT_LOCATOR_ACCOUNT = "//*[text()='%s']/../following-sibling::input";


    public LightningInputAccount(WebDriver driver, String label) {
        super(driver, label);
    }

    public void seyValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_LOCATOR_ACCOUNT, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.debug("Setting input value = %s to input with locator = %s", String.format(INPUT_LOCATOR_ACCOUNT, label), value);
            inputElement.sendKeys(value);
        }
    }
}
