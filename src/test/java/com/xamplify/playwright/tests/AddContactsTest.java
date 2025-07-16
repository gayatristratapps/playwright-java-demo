package com.xamplify.playwright.tests;

import org.testng.annotations.Test;

import com.xamplify.playwright.base.BaseTest;
import com.xamplify.playwright.pages.AddContactsPage;
import com.xamplify.playwright.pages.PartnerLoginPage;

public class AddContactsTest extends BaseTest {

   
    // ✅ Declare it here so all methods can use it
    AddContactsPage addContactsPage;

    @Test(enabled=true)
    public void testAddNewContact() {
        PartnerLoginPage loginPage = new PartnerLoginPage(page);
        loginPage.goToLoginPage();
        loginPage.login("partnerautomate@gmail.com", "Xamplify@11");

        // ✅ Initialize here
        addContactsPage = new AddContactsPage(page);
        addContactsPage.goToAddContactsPage();

        addContactsPage.clickOneAtATimeTab();
        addContactsPage.fillAddContactForm();
        addContactsPage.submitAddContactForm();
        addContactsPage.fillContactListDetails("AutoList", true);
    }

    @Test(enabled=false)
    public void testAddNewContactUploadCSV() {
        // ✅ Also initialize here before use
        addContactsPage = new AddContactsPage(page);
        addContactsPage.goToAddContactsPage(); // optional: in case navigation is needed

        addContactsPage.clickUploadCsvTab();
        addContactsPage.uploadCsvFile("C:/path/to/your/file.csv");
        addContactsPage.fillContactListDetails("JulyListAuto", true);
        addContactsPage.clickSave();
    }
}