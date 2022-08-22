package elements.contact;

import elements.BaseElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2
public class LightningBaseComboboxContact extends BaseElement {

        private final static String NEW_LOCATOR = "//span[@title='New Account']";
        private final static String WAIT_LOCATOR = "//span[text()='Account Information']";
    private final static String BUTTON_LOCATOR = "//*[@class='slds-combobox__input slds-input' and @placeholder='%s']";
    private final static String ACCOUNT_SAVE = "//button[@title='Save']";
    private final static String ACCOUNT_INPUT = "//span[text()='Account Name']/../following-sibling::div[1]//input";

        public LightningBaseComboboxContact(WebDriver driver, String label) {
            super(driver, label);
        }

        public void selectByVisibleText(String value) {
            WebElement inputElement = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
            scrollIntoView(inputElement);
            if (Objects.nonNull(value)) {
                log.debug("Setting input value = %s to input with locator = %s", String.format(BUTTON_LOCATOR, label), value);
                inputElement.click();
                waitForElementClicable((By.xpath(String.format(NEW_LOCATOR))));
                driver.findElement(By.xpath(String.format(NEW_LOCATOR))).click();
                waitForElementClicable((By.xpath(String.format(WAIT_LOCATOR))));
                WebElement name = driver.findElement(By.xpath(String.format(ACCOUNT_INPUT)));
                name.sendKeys(value);
                driver.findElement(By.xpath(String.format(ACCOUNT_SAVE))).click();

            }
        }
}
