package pages;

import elements.LightningFormattedElement;
import enums.Industry;
import enums.Type;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage {
    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public Account getAccountInfo() {
        log.info("Retrieving existing values from a partition Details");
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        Account.AccountBuilder accountBuilder = Account.builder().accountName(accountName);
        String type = new LightningFormattedElement(driver, "Type").getText();
        if (type != "") {
            accountBuilder.type(Type.fromString(type));
        }
        String webSite = new LightningFormattedElement(driver, "Website").getText();
        if (webSite != "") {
            accountBuilder.webSite(webSite);
        }
        String description = new LightningFormattedElement(driver, "Description").getText();
        if (description != "") {
            accountBuilder.description(description);
        }
        String parentAccount = new LightningFormattedElement(driver, "Parent Account").getText();
        if (parentAccount != "") {
            accountBuilder.parentAccount(parentAccount);
        }
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            accountBuilder.phone(phone);
        }
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        if (industry != "") {
            accountBuilder.industry(Industry.fromString(industry));
        }
        String employees = new LightningFormattedElement(driver, "Employees").getText();
        if (employees != "") {
            accountBuilder.employees(employees);
        }
        String billingAddress = new LightningFormattedElement(driver, "Billing Address").getText().replace('\n',' ');
        String[] parsedAddress = billingAddress .split(" ");
        accountBuilder.billingStreet(parsedAddress[0])
                .billingAddress(parsedAddress[1])
                .billingProvince(parsedAddress[2])
                .billingPostalCode(parsedAddress[3]);

        String shippingAddress = new LightningFormattedElement(driver, "Shipping Address").getText().replace('\n',' ');
        String[] parsedShippingAddress = shippingAddress .split(" ");
        accountBuilder.shippingAddress(parsedShippingAddress[0])
                .shippingStreet(parsedShippingAddress[1])
                .shippingProvince(parsedShippingAddress[2])
                .shippingPostalCode(parsedShippingAddress[3]);

        return accountBuilder.build();
    }
}

