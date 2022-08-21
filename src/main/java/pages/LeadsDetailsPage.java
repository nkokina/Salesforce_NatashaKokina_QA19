package pages;

import elements.LightningFormattedElement;
import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Salutation;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class LeadsDetailsPage extends BasePage {
    private final static By DETAILS_BUTTON =
            By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public LeadsDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Lead getLeadInfo() {
        log.info("Retrieving existing values from a partition Details");
        Lead.LeadBuilder leadBuilder = Lead.builder();

        String company = new LightningFormattedElement(driver, "Company").getText();
        String name = new LightningFormattedElement(driver, "Name").getText();
        String leadStatus = new LightningFormattedElement(driver, "Lead Status").getText();

        String[] parsedName = name.split(" ");

        leadBuilder.salutation(Salutation.fromString(parsedName[0]));
        leadBuilder.firstName(parsedName[1]);
        leadBuilder.middleName(parsedName[2]);
        leadBuilder.lastName(parsedName[3]);
        leadBuilder.suffix(parsedName[4]);

        leadBuilder.company(company)
                .leadStatus(LeadStatus.fromString(leadStatus));

        String title = new LightningFormattedElement(driver, "Title").getText();
        if (title != "") {
            leadBuilder.title(title);
        }
        String email = new LightningFormattedElement(driver, "Email").getText();
        if (email != "") {
            leadBuilder.email(email);
        }
        String webSite = new LightningFormattedElement(driver, "Website").getText();
        if (webSite != "") {
            leadBuilder.webSite(webSite);
        }
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            leadBuilder.phone(phone);
        }
        String mobilePhone = new LightningFormattedElement(driver, "Mobile").getText();
        if (mobilePhone != "") {
            leadBuilder.mobilePhone(mobilePhone);
        }
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        if (industry != "") {
            leadBuilder.industry(Industry.fromString(industry));
        }
        String numberOfEmployees = new LightningFormattedElement(driver, "No. of Employees").getText();
        if (numberOfEmployees != "") {
            leadBuilder.numberOfEmployees(numberOfEmployees);
        }
        String leadSource = new LightningFormattedElement(driver, "Lead Source").getText();
        if (leadSource != "") {
            leadBuilder.leadSource(LeadSource.fromString(leadSource));
        }
        String address = new LightningFormattedElement(driver, "Address").getText().replace('\n', ' ').replace(",", "");
        String[] parsedAddress = address.split(" ");
        leadBuilder.street(parsedAddress[0])
                .address(parsedAddress[1])
                .province(parsedAddress[2])
                .postalCode(parsedAddress[3]);

        return leadBuilder.build();
    }
}
