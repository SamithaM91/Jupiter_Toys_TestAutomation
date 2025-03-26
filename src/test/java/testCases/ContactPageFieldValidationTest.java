package testCases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactPageFieldValidationTest extends BaseClass {

    @Test
    public void TC001(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToContactPage();

        ContactPage contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.isOnContactPage(), "User is NOT on the Contact page!");
        contactPage.clickSubmit();
        Assert.assertTrue(contactPage.areErrorsDisplayed(), "Error messages should be displayed!");

        contactPage.fillMandatoryFields("Dasun", "dasun@example.com", "This is a test message.");

        Assert.assertTrue(contactPage.areErrorsGone(), "Error messages should disappear after filling in fields!");
    }

}
