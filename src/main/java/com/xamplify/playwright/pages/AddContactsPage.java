package com.xamplify.playwright.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;

public class AddContactsPage {
    private final Page page;

    public AddContactsPage(Page page) {
        this.page = page;
        this.uploadCsvBtn = page.locator("#Uploadcsv"); // Adjust this ID or XPath
        this.fileInput = page.locator("input[type='file']"); // Hidden input
        this.saveBtn = page.locator("#Custom_Csv_Modal_Popup button:has-text('Save'):not([disabled])");
    
    }

    // Navigate to Add Contacts menu
    public void goToAddContactsPage() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contacts")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Contacts")).click();
    }

    // Click "Upload a CSV" option
    public void clickUploadCsvTab() {
        page.locator("text=Upload a CSV").click();
    }

    
   
    
    
    
    
    
    
    // ✅ Click "One at a Time" option
    public void clickOneAtATimeTab() {
        page.locator("text=One at a Time").click();
    }
    
    
    public void fillAddContactForm() {
        // Fill email, first name, last name
        page.getByPlaceholder("Email", new Page.GetByPlaceholderOptions().setExact(true)).fill("Automatecon@example.com");
        page.locator("input[placeholder='First Name']").fill("Test");
        page.locator("input[placeholder='Last Name']").fill("Gayatri");
        
        Locator legalInput = page.locator("//*[@id='multiselectelement']//span[3]/input");

        // Scroll into view and click input
       // legalInput.scrollIntoViewIfNeeded();
       //legalInput.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        legalInput.click();

        // Type first value and press Enter
        legalInput.fill("Legitimate interest - existing customer");

      
        page.keyboard().press("Enter");
        
        
        Locator addCompanyBtn = page.locator("#addContactuser");

        
       
        try {
            addCompanyBtn.click(new Locator.ClickOptions().setTimeout(5000));
        } catch (PlaywrightException e) {
            System.out.println("Normal click failed, using JS click fallback");
            // Use selector string directly in JS instead of passing Locator
            page.evaluate("document.querySelector(\"button:has-text('+')\").click()");
        }

        // Step 2: Wait for modal to be visible
        Locator modal = page.locator("#addCompanyModal");
        modal.waitFor(new Locator.WaitForOptions().setTimeout(5000).setState(WaitForSelectorState.VISIBLE));

        // Step 3: Fill 'Name' field
        Locator nameInput = page.locator("#name");
        nameInput.scrollIntoViewIfNeeded();
        nameInput.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        nameInput.click();
        nameInput.fill("AutoTestCompany");

        // Step 4: Fill website
        page.locator("#website").fill("www.automate.com");

       
        
        
        
        
        Locator addButton = page.locator("//div[@id='addCompanyModal']//button[2]");
        addButton.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        addButton.click();


     //   page.locator("button:has-text('Add')").click();

        // Step 6: Retry logic if duplicate entry found
        try {
            Locator responseMsg = page.locator("#responseMessage");
            responseMsg.waitFor(new Locator.WaitForOptions().setTimeout(3000));
            String msgText = responseMsg.innerText();

            if (msgText.contains("Duplicate Entry for Company Name")) {
                String uniqueCompanyName = "AutoTestCompany_" + System.currentTimeMillis();
                nameInput.fill(uniqueCompanyName);
                page.locator("//div[@id='addCompanyModal']//button[2]").click();
            }
        } catch (Exception e) {
            System.out.println("No duplicate message. Proceeding...");
        }
        
        
        
        
        
    }    
        
        
        
    
    
    
    
    public void submitAddContactForm() {
       // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        
        
        Locator addContactBtn = page.locator("//div[@id='addContactModal']//button[2]");
        addContactBtn.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        addContactBtn.click();

        
        
    }
    
    
 // Uploads the given CSV file
    public void uploadCsv(String filePath) {
        page.setInputFiles("input[type='file'][accept='.csv']", Paths.get(filePath));
    }
    
	/*
	 * public void uploadCsvFile(String csvPath) {
	 * page.setInputFiles("input[type='file']", Paths.get(csvPath)); }
	 */
    
    
    
    
    

    public void fillContactListDetails(String listName, boolean isPublic) {
        page.locator("input[placeholder='List Name']").fill(listName);

		/*
		 * if (isPublic) { page.locator("text=Public").click(); } else {
		 * page.locator("text=Private").click(); }
		 */
    }

    public void clickSave() {
     //   page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
    	
    	
    	
        Locator saveBtn = page.locator("//button[span[contains(text(),'Save')]]");
        saveBtn.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        saveBtn.click();

    }
    
    
    public void clickSaveCSV() {
    	
    	page.waitForSelector("//button[@id='sample_editable_1_new']//span[@class='btn Btn-Green transition text_pd5']");
    	page.locator("//button[@id='sample_editable_1_new']//span[@class='btn Btn-Green transition text_pd5']").click();

    	
    }
    
    public void Acceptsave() {
    
    	page.waitForSelector("//div[@id='tcModal']//button//span[contains(text(),'Accept')]");
    	page.locator("//div[@id='tcModal']//button//span[contains(text(),'Accept')]").click();

    }
    

    // Locators
    private Locator uploadCsvBtn;
    private Locator fileInput;
    private Locator saveBtn;

       

    public void uploadCsvFile(String csvPath) {
        // Wait for file input to be visible
        fileInput.waitFor(new Locator.WaitForOptions().setTimeout(5000).setState(WaitForSelectorState.ATTACHED));

        // Upload file
        fileInput.setInputFiles(Paths.get(csvPath));
        System.out.println("CSV File set: " + csvPath);
    }

    
    public void legal( ) {
    
 // Locate the dropdown input element
    Locator legalBasisInput = page.locator("//input[@placeholder='Select Legal Basis']");

    // Click to activate dropdown
    legalBasisInput.click();

    // Wait for dropdown to open (optional, if there's a delay)
    page.waitForTimeout(500);

    // Select first option
    legalBasisInput.fill("Legitimate interest - existing customer");
    page.keyboard().press("Enter");
    
    
    }
    
    
    
}
