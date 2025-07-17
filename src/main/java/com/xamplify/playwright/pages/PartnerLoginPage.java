package com.xamplify.playwright.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;

public class PartnerLoginPage {
    private Page page;

    public PartnerLoginPage(Page page) {
        this.page = page;
    }

    public void goToLoginPage() {
     
        
        page.navigate("https://xamplify.co/login",
                new Page.NavigateOptions()
                    .setTimeout(60000)
                    .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        
        
        
        
        
        
    }

    public void login(String email, String password) {

    	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill(email);
    	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill(password);
    	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In to Sandbox")).click();
    }
}
