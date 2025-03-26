package testCases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactPageSubmitValidationTest extends BaseClass {

    @DataProvider(name = "validFormData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Samitha", "samitha@example.com", "Hello Samitha!"},
                {"Anupama", "anupama@example.com", "Hello Anupama!"},
                {"Yashoda", "yashoda@example.com", "Hello Yashoda!"},
                {"Dasun", "dasun@example.com", "Hello Dasun!"},
                {"Nevan", "nevan@example.com", "Hello Nevan!"}
        };
    }

    @Test(dataProvider = "validFormData")
    public void TC002(String forename, String email, String message) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToContactPage();

        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillMandatoryFields(forename, email, message);
        contactPage.clickSubmit();
        Assert.assertFalse(contactPage.areErrorsDisplayed(), "Success Message should be displayed");

    }

}