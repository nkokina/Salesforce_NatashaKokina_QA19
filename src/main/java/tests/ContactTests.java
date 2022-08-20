package tests;

import enums.Salutation;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.ContactPage;
import pages.modals.NewContactModal;

public class ContactTests extends BaseTest {

    private ContactPage contactPage;
    private NewContactModal newContactModal;
    private ContactDetailsPage contactDetailsPage;

    @BeforeClass
    public void initialise() {
        contactPage = new ContactPage(driver);
        newContactModal = new NewContactModal(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
    }


    @Test(dataProvider = "createContactTestData")
    public void createContactTest(Contact testContact) {
        loginPage.login(USERNAME, PASSWORD);
        homePage.waitForUserIconDisplayed();
        homePage.openContactsTab();
        contactPage.waitForPageLoaded();
        contactPage.openNewButton();
        contactPage.waitForPageLoadedNew();
        Assert.assertTrue(contactPage.isContactsIconDisplayed(), "Contacts page transition failed");
        newContactModal.fillingOutTheForm(testContact);
        newContactModal.clickSaveButton();
        contactPage.openDetails();
        Assert.assertEquals(contactDetailsPage.getContactInfo(), testContact, "Data does not match");

    }

    @DataProvider
    public Object[][] createContactTestData() {
        return new Object[][]{
                {Contact.builder().lastName(faker.name().lastName()).firstName(faker.name().firstName()).salutation(Salutation.MS)
                        .middleName(faker.name().username()).suffix(faker.name().suffix()).title(faker.name().title())
                        .email(faker.internet().emailAddress()).phone(faker.phoneNumber().phoneNumber())
                        .mobilePhone(faker.phoneNumber().phoneNumber()).accountName(faker.name().name())
                        .department(faker.company().name()).fax(faker.phoneNumber().phoneNumber())
                        .mailingAddress("Minsk").street("Ykrainki").province("Minskiy").postalCode(faker.address().zipCode())
                        .build()},

                {Contact.builder().lastName(faker.name().lastName()).accountName(faker.name().firstName())
                        .mailingAddress("Minsk").street("Ykrainki").province("Minskiy").postalCode(faker.address().zipCode())
                        .build()},
        };
    }
}
