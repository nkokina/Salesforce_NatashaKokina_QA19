package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

@Log4j2
public class LightningBaseCombobox extends BaseElement {
    private final static String BUTTON_LOCATOR =
            "//*[@class='slds-combobox__input slds-input' and @placeholder='%s']";
    private final static String BUTTON_LOCATOR_ACCOUNT =
            "//*[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup' and @placeholder='%s']";
    private final static String WAIT_LOCATOR = "//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click slds-is-open']";

    public LightningBaseCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            log.debug("Setting input value = %s to input with locator = %s",
                    String.format(BUTTON_LOCATOR, label), value);
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }
    }

    public void selectByVisibleTextAccount(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR_ACCOUNT, label)));
        if (Objects.nonNull(value)) {
            log.debug("Setting input value = %s to input with locator = %s",
                    String.format(BUTTON_LOCATOR_ACCOUNT, label), value);
            scrollIntoView(inputElement);
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath(String.format(WAIT_LOCATOR))));
            inputElement.sendKeys(Keys.DOWN, Keys.ENTER);
        }
    }
}
