package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class LightningContactBaseCombobox extends BaseElement {
    private final static String BUTTON_LOCATOR = "//*[@class='slds-combobox__input slds-input' and @placeholder='%s']";

    public LightningContactBaseCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        scrollIntoView(inputElement);
        if (Objects.nonNull(value)) {
            log.debug("Setting input value = %s to input with locator = %s", String.format(BUTTON_LOCATOR, label), value);
            inputElement.click();
            inputElement.sendKeys(Keys.DOWN, Keys.ENTER);
        }
    }
}

