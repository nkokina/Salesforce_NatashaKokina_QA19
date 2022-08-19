package tests;

import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Salutation;
import models.Lead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LeadsDetailsPage;
import pages.LeadsPage;
import pages.modals.NewLeadModal;

public class LeadsTests extends BaseTest {

    private LeadsPage leadsPage;
    private LeadsDetailsPage leadsDetailsPage;
    private NewLeadModal newLeadModal;

    @BeforeClass
    public void initialise() {
        leadsPage = new LeadsPage(driver);
        leadsDetailsPage = new LeadsDetailsPage(driver);
        newLeadModal = new NewLeadModal(driver);
    }

    @Test(dataProvider = "newLeadData")
    public void createLeadTest(Lead testLead) {
        loginPage.login(USERNAME, PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        leadsPage.openNewButton();
        leadsPage.waitForPageLoadedNew();
        Assert.assertTrue(leadsPage.isLeadsIconDisplayed(), "Leads page transition failed");

        newLeadModal.fillingOutTheForm(testLead);
        newLeadModal.clickSaveButton();
        leadsPage.waitForPopupPresent();
        Assert.assertTrue(leadsPage.isConfimationPopupPresent("was created"), "Lead not saved");
        leadsPage.openDetails();
        Assert.assertEquals(leadsDetailsPage.getLeadInfo(), testLead, "Data does not match");
    }

    @DataProvider(name = "newLeadData")
    public Object[][] createLeadTestData() {
        return new Object[][]{
                {Lead.builder().company(faker.company().name()).leadStatus(LeadStatus.WORKING).lastName(faker.name().lastName())
                        .firstName(faker.name().firstName()).salutation(Salutation.MS).suffix(faker.name().suffix())
                        .middleName(faker.name().username()).title(faker.name().title()).email(faker.internet().emailAddress())
                        .webSite(faker.internet().emailAddress()).phone(faker.phoneNumber().phoneNumber())
                        .mobilePhone(faker.phoneNumber().phoneNumber()).industry(Industry.BIOTECHNOLOGY)
                        .numberOfEmployees(faker.number().digit()).leadSource(LeadSource.EMPLOYEE)
                        .address("Minsk").street("Ykrainki").province("Minskiy").postalCode(faker.address().zipCode())
                        .build()},
                {Lead.builder().company(faker.company().name()).leadStatus(LeadStatus.WORKING).lastName(faker.name().lastName())
                        .firstName(faker.name().firstName()).salutation(Salutation.MS).suffix(faker.name().suffix())
                        .middleName(faker.name().username()).address("Minsk").street("Ykrainki").province("Minskiy")
                        .postalCode(faker.address().zipCode()).build()},
        };
    }
}