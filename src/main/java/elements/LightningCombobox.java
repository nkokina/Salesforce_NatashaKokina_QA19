package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class LightningCombobox extends BaseElement {
    private final static String BUTTON_LOCATOR = "//label[text()='%s']/following-sibling::div";
    private final static String COMBOBOX_LOCATOR
            = "//*[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain']//span[text()='%s']";
   private final static String WAIT_LOCATOR="//*[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']";
    public LightningCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
            if (Objects.nonNull(visibleText)) {
                scrollIntoView(button);
                log.debug("Setting input value = %s to input with locator = %s", String.format(BUTTON_LOCATOR, label), visibleText);
                button.click();
                waitForElementClicable(By.xpath(String.format(WAIT_LOCATOR)));
                WebElement option = driver.findElement(By.xpath(String.format(COMBOBOX_LOCATOR, visibleText)));
                scrollIntoView(option);
                option.click();
        }
    }
}
