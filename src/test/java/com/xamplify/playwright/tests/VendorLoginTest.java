package com.xamplify.playwright.tests;

import com.microsoft.playwright.Page;
import com.xamplify.playwright.base.PlaywrightFactory;
import com.xamplify.playwright.pages.VendorLoginPage;
import com.xamplify.playwright.pages.CommonLogoutPage;
import org.testng.annotations.*;

public class VendorLoginTest {
    PlaywrightFactory factory;
    Page page;
    VendorLoginPage loginPage;
    CommonLogoutPage logoutPage;

    @BeforeMethod
    public void setup() {
        factory = new PlaywrightFactory();
        page = factory.initBrowser();
        loginPage = new VendorLoginPage(page);
        logoutPage = new CommonLogoutPage(page);
    }

    @Test
    public void testVendorLoginLogout() {
        loginPage.goToLoginPage();
        loginPage.login("vendor@example.com", "vendorpassword");
        logoutPage.logout();
    }

	/*
	 * @AfterMethod public void teardown() { factory.close(); }
	 */
}
