package elements.account;

import elements.BaseElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class LightningInputAccountAddress extends BaseElement {

    private final static String BUTTON_LOCATOR =
            "//*[text()='%s']/../following-sibling::div/div/button";
    private final static String ADDRESS_LOCATOR =
            "//*[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input']";
    private final static String WAIT_LOCATOR="//div[@class='undefined lookup__menu uiAbstractList uiAutocompleteList']";

    public LightningInputAccountAddress(WebDriver driver, String label) {
        super(driver, label);
    }

    public void seyValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            inputElement.click();
            waitForElementClicable(By.xpath(String.format(ADDRESS_LOCATOR)));
            WebElement addressElement = driver.findElement(By.xpath(String.format(ADDRESS_LOCATOR)));
            addressElement.sendKeys(value);
            log.debug("Setting input value = %s to input with locator = %s", String.format(BUTTON_LOCATOR, label), value);
           waitForElementClicable(By.xpath(String.format(WAIT_LOCATOR)));
            addressElement.sendKeys(Keys.ENTER);
        }
    }
}
