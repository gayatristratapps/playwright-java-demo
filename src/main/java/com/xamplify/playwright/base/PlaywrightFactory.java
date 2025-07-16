package com.xamplify.playwright.base;

import java.util.List;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    public Playwright playwright;
    public Browser browser;
    public BrowserContext context;
    public Page page;

    public Page initBrowser() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            .setHeadless(false)
            .setArgs(List.of("--start-maximized")) // ✅ correct usage

        );

        context = browser.newContext(new Browser.NewContextOptions()
            .setViewportSize(null) // ✅ Allow full window size based on screen
        );

        page = context.newPage();
        return page;
    }

	/*
	 * public void close() { if (page != null) page.close(); if (context != null)
	 * context.close(); if (browser != null) browser.close(); if (playwright !=
	 * null) playwright.close(); }
	 */
}
