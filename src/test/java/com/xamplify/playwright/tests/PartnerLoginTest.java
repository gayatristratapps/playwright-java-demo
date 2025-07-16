package com.xamplify.playwright.tests;

import com.microsoft.playwright.Page;
import com.xamplify.playwright.base.PlaywrightFactory;
import com.xamplify.playwright.pages.PartnerLoginPage;
import com.xamplify.playwright.pages.CommonLogoutPage;
import org.testng.annotations.*;

public class PartnerLoginTest {
    PlaywrightFactory factory;
    Page page;
    PartnerLoginPage loginPage;
    CommonLogoutPage logoutPage;

    @BeforeMethod
    public void setup() {
        factory = new PlaywrightFactory();
        page = factory.initBrowser();
        loginPage = new PartnerLoginPage(page);
        logoutPage = new CommonLogoutPage(page);
    }

    @Test
    public void testPartnerLoginLogout() {
        loginPage.goToLoginPage();
        loginPage.login("partnerautomate@gmail.com", "Xamplify@11");
        logoutPage.logout();
    }

	/*
	 * @AfterMethod public void teardown() { factory.close(); }
	 */
}
