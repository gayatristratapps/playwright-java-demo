package com.xamplify.playwright.tests;

import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import com.xamplify.playwright.base.BaseTest;
import com.xamplify.playwright.pages.AddContactsPage;
import com.xamplify.playwright.pages.PartnerLoginPage;

import utils.FileUtil;

public class AddContactsTest extends BaseTest {

	// ✅ Declare it here so all methods can use it
	AddContactsPage addContactsPage;

	@Test(enabled = false)
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
		addContactsPage.Acceptsave();

	}

	@Test(enabled = true)
	public void testAddNewContactUploadCSV() throws IOException {
		// Step 1: Login first
		PartnerLoginPage loginPage = new PartnerLoginPage(page);
		loginPage.goToLoginPage();
		loginPage.login("partnerautomate@gmail.com", "Xamplify@11");

		// Step 2: Initialize Page class
		addContactsPage = new AddContactsPage(page);

		// Step 3: Navigate to Contacts Page
		addContactsPage.goToAddContactsPage();

		// addContactsPage.clickUploadCsvTab();

		String csvPath = FileUtil.generateCsvFile("upload_contacts.csv");
		System.out.println("Generated CSV Path: " + csvPath);

		addContactsPage.uploadCsvFile(csvPath);

		addContactsPage.fillContactListDetails("JulyListAuto", true);

		addContactsPage.legal();

		addContactsPage.clickSaveCSV();

		addContactsPage.Acceptsave();

	}

	

}