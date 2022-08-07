package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class EntityBasePage extends BasePage {
    private final static By ENTITIES_LINKS_LOCATOR = By.cssSelector("table[role=grid] a[data-refid=recordId]");
    private final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    private final static By DETAIL_BUTTON = By.xpath("//*[@class='windowViewMode-normal oneContent active lafPageHost']// li[@title='Details']");
    private final static By POPUP_PRESENT = By.cssSelector(".sids-theme--sucess slds-notify--toast slds-notify slds-notify--toast forceToastMessage toastHidden");
    public EntityBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(NEW_BUTTON);
        waitForElementClicable(NEW_BUTTON);
    }

    public void openDetails() {
        driver.findElement(DETAIL_BUTTON).click();

    }
    public void openNewButton() {
        driver.findElement(NEW_BUTTON).click();

    }

    public void openEntityByName(String entityName) {
        List<WebElement> allLinks = getAllEntitiesLinks();
        allLinks.stream().filter(webElement -> webElement.getText().equals(entityName)).findFirst().get().click();
    }

    public void openFirstEntityFromTable() {
        List<WebElement> allLinks = getAllEntitiesLinks();
        allLinks.get(0).click();
    }

    public List<WebElement> getAllEntitiesLinks() {
        return driver.findElements(ENTITIES_LINKS_LOCATOR);
    }

    public boolean isConfimationPopupPresent() {
        return driver.findElement(POPUP_PRESENT).isDisplayed();
    }
}

