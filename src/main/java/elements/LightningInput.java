package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class LightningInput extends BaseElement {
    private final static String INPUT_LOCATOR = "//label[text()='%s']/following-sibling::div/input";
    private final static String INPUT_LOCATOR_ACCOUNT = "//*[text()='%s']/../following-sibling::input";
    private final static String BUTTON_LOCATOR_ACCOUNT =
            "//*[text()='%s']/../following-sibling::div/div/button";
    private final static String ADDRESS_LOCATOR_ACCOUNT =
            "//*[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input']";
    private final static String ACCOUNT_NAME_LOCATOR =
            "//span[text()='%s']/../following-sibling::div/div/div/div/input";

    public LightningInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.debug("Setting input value = %s to input with locator = %s", String.format(INPUT_LOCATOR, label), value);
            inputElement.sendKeys(value);
        }
    }

    public void seyValueAccount(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_LOCATOR_ACCOUNT, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.debug("Setting input value = %s to input with locator = %s", String.format(INPUT_LOCATOR_ACCOUNT, label), value);
            inputElement.sendKeys(value);
        }
    }

    public void seyValueAccountName(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(ACCOUNT_NAME_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.debug("Setting input value = %s to input with locator = %s", String.format(ACCOUNT_NAME_LOCATOR, label), value);
            inputElement.sendKeys(value);
        }
    }

    public void seyValueAccountButton(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR_ACCOUNT, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            inputElement.click();
            WebElement addressElement = driver.findElement(By.xpath(String.format(ADDRESS_LOCATOR_ACCOUNT)));
            addressElement.sendKeys(value);
            log.debug("Setting input value = %s to input with locator = %s", String.format(BUTTON_LOCATOR_ACCOUNT, label), value);
            addressElement.sendKeys(Keys.DOWN);
            addressElement.sendKeys(Keys.ENTER);
        }
    }
}
