package elements.account;

import elements.BaseElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;
@Log4j2
public class LightningBaseComboboxAccount extends BaseElement {

    private final static String BUTTON_LOCATOR_ACCOUNT =
            "//*[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup' and @placeholder='%s']";
    private final static String WAIT_LOCATOR ="//span[@title='New Account']";

    public LightningBaseComboboxAccount(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR_ACCOUNT, label)));
        if (Objects.nonNull(value)) {
            log.debug("Setting input value = %s to input with locator = %s",
                    String.format(BUTTON_LOCATOR_ACCOUNT, label), value);
            scrollIntoView(inputElement);
            inputElement.click();
            waitForElementClicable(By.xpath(String.format(WAIT_LOCATOR)));
            inputElement.sendKeys(Keys.DOWN, Keys.ENTER);
        }
    }
}
