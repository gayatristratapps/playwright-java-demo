package com.xamplify.playwright.base;

import com.microsoft.playwright.Page;
import com.xamplify.playwright.base.PlaywrightFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected Page page;  // ✅ Shared with test classes
    private PlaywrightFactory pf; // ✅ UPDATED

    @BeforeClass
    public void setUp() {
        pf = new PlaywrightFactory();        // ✅ Initialize factory
        page = pf.initBrowser();             // ✅ Reuse browser/page creation
    }

	/*
	 * @AfterClass public void tearDown() { if (pf != null) { pf.close(); // ✅
	 * Centralized close } }
	 */
}
