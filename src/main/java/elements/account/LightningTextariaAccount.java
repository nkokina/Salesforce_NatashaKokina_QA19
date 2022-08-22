package elements.account;

import elements.BaseElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class LightningTextariaAccount extends BaseElement {

    private final static String TEXTARIA_LOCATOR = "//span[text()='%s']/../following-sibling::textarea";

    public LightningTextariaAccount(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(TEXTARIA_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            log.debug("Setting input value = %s to input with locator = %s", String.format(TEXTARIA_LOCATOR, label), value);
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }
    }
}
