package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    private final static By SALUTATION = By.xpath(
            "//*[@class='slds-combobox__input slds-input_faux slds-combobox__input-value' and @name='salutation']");
    private final static By SAVE_BUTTON = By.xpath("//*[@class='slds-button slds-button_brand' and text()='Save']");
    private final static By LAST_NAME = By.xpath("//*[@class='slds-input' and @name='lastName']");
    private final static By FIRST_NAME = By.xpath("//*[@class='slds-input' and @name='firstName']");
    private final static By MIDDLE_NAME = By.xpath("//*[@class='slds-input' and @name='middleName']");
    private final static By SUFFIX = By.xpath("//*[@class='slds-input' and @name='suffix']");
    private final static By TITLE = By.xpath("//*[@class='slds-input' and @name='Title']");
    private final static By EMAIL = By.xpath("//*[@class='slds-input' and @name='Email']");
    private final static By PHONE = By.xpath("//*[@class='slds-input' and @name='Phone']");
    private final static By MOBILE_PHONE = By.xpath("//*[@class='slds-input' and @name='MobilePhone']");
    private final String SALUTATION_OPTION = "//*[@class='slds-truncate' and text()='%s']";
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public abstract void waitForPageLoaded();

    public void clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
    }

    public void waitForElementDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void setLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void setFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void setMiddleName(String middleName) {
        driver.findElement(MIDDLE_NAME).sendKeys(middleName);
    }

    public void getLeadsSalutation(String salutation) {
        driver.findElement(SALUTATION).click();
        driver.findElement(By.xpath(String.format(SALUTATION_OPTION, salutation))).click();
    }

    public void setSuffix(String suffix) {
        driver.findElement(SUFFIX).sendKeys(suffix);
    }

    public void setTitle(String title) {
        driver.findElement(TITLE).sendKeys(title);
    }

    public void setEmail(String email) {
        driver.findElement(EMAIL).sendKeys(email);
    }

    public void setPhone(String phone) {
        driver.findElement(PHONE).sendKeys(phone);
    }

    public void setMobilePhone(String mobilePhone) {
        driver.findElement(MOBILE_PHONE).sendKeys(mobilePhone);
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }
}