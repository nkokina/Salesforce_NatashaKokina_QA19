package elements.account;

import elements.BaseElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class LightningInputAccountName extends BaseElement {
    private final static String NAME_LOCATOR =
            "//span[text()='%s']/../following-sibling::div/div/div/div/input";

    public LightningInputAccountName(WebDriver driver, String label) {
        super(driver, label);
    }
    public void seyValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(NAME_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.debug("Setting input value = %s to input with locator = %s", String.format(NAME_LOCATOR, label), value);
            inputElement.sendKeys(value);
        }
    }
}
