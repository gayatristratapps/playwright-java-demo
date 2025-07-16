package com.xamplify.playwright.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class VendorLoginPage {
    private Page page;

    public VendorLoginPage(Page page) {
        this.page = page;
    }

    public void goToLoginPage() {
        page.navigate("https://xamplify.co/login");
    }

    public void login(String email, String password) {
    	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill(email);
    	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill(password);
    	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
