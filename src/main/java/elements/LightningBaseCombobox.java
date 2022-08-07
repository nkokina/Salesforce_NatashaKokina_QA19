package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class LightningBaseCombobox extends BaseElement {
    private final static String BUTTON_LOCATOR = "//*[@class='slds-combobox__input slds-input' and @placeholder='%s']";
    private final static String BASE_COMBOBOX_OPTION = "//*[@class='slds-truncate' and @title='%s']";

    public LightningBaseCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        System.out.printf("Setting %s input value = %s", label, value);
        scrollIntoView(inputElement);
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            System.out.println("log");
        }
        inputElement.sendKeys(value);

        WebElement button = driver.findElement(By.xpath(String.format(BASE_COMBOBOX_OPTION, value)));
        scrollIntoView(button);
        button.click();
        System.out.printf("Setting %s combobox value = %s", label, value);
    }
}
