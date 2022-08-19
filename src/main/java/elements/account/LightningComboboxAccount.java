package elements.account;

import elements.BaseElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2
public class LightningComboboxAccount extends BaseElement {
    private final static String BUTTON_LOCATOR = "//span[@class='' and text()='%s']/../following-sibling::div";
    private final static String COMBOBOX_LOCATOR = "//*[@class='uiMenuItem uiRadioMenuItem']//a[text()='%s']";

    public LightningComboboxAccount(WebDriver driver, String label) {
        super(driver, label);
    }


    public void selectByVisibleText(String visibleText) {
        WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        scrollIntoView(button);
        if (Objects.nonNull(visibleText)) {
            log.debug("Setting input value = %s to input with locator = %s", String.format(BUTTON_LOCATOR, label), visibleText);
            button.click();
            WebElement option = driver.findElement(By.xpath(String.format(COMBOBOX_LOCATOR, visibleText)));
            scrollIntoView(option);
            option.click();
        }
    }
}
