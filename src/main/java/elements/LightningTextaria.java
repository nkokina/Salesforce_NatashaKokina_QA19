package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class LightningTextaria extends BaseElement{

    private final static String TEXTARIA_LOCATOR = "//label[text()='%s']/following-sibling::div/textarea";

    public LightningTextaria(WebDriver driver, String label) {
        super(driver, label);
    }
    public void setValue(String value){
        WebElement inputElement=driver.findElement(By.xpath(String.format(TEXTARIA_LOCATOR, label)));
        System.out.printf("Setting %s input value = %s", label, value);
        scrollIntoView(inputElement);
        if(Objects.nonNull(value)){
            scrollIntoView(inputElement);
            System.out.printf("Setting %s input value = %s", label, value);
        }
        inputElement.sendKeys(value);

    }
}
