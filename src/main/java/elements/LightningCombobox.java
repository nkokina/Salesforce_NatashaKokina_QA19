package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class LightningCombobox extends BaseElement {
    private final static String BUTTON_LOCATOR = "//label[text()='%s']/following-sibling::div";
    private final static String COMBOBOX_LOCATOR = "//*[@class='slds-media__body']//span[text()='%s']";
    private final static String BUTTON_LOCATOR_ACCOUNT = "//span[@class='' and text()='%s']/../following-sibling::div";
    private final static String COMBOBOX_LOCATOR_ACCOUNT = "//*[@class='uiMenuItem uiRadioMenuItem']//a[text()='%s']";

    public LightningCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        if (Objects.nonNull(visibleText)) {
            scrollIntoView(button);
            log.debug("Setting input value = %s to input with locator = %s", String.format(BUTTON_LOCATOR, label), visibleText);
            button.click();
            WebElement option = driver.findElement(By.xpath(String.format(COMBOBOX_LOCATOR, visibleText)));
            scrollIntoView(option);
            option.click();
        }
    }

    public void selectByVisibleTextAccount(String visibleText) {
        WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR_ACCOUNT, label)));
        scrollIntoView(button);
        if (Objects.nonNull(visibleText)) {
            log.debug("Setting input value = %s to input with locator = %s", String.format(BUTTON_LOCATOR_ACCOUNT, label), visibleText);
            button.click();
            WebElement option = driver.findElement(By.xpath(String.format(COMBOBOX_LOCATOR_ACCOUNT, visibleText)));
            scrollIntoView(option);
            option.click();
        }
    }
}
