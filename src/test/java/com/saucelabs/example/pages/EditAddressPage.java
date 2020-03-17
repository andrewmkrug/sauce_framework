package com.saucelabs.example.pages;

import com.saucelabs.example.data.AddressData;
import com.saucelabs.framework.elements.Element;
import com.saucelabs.framework.elements.TextField;
import org.openqa.selenium.By;

public class EditAddressPage extends BasePage {

    protected TextField firstName = new TextField(browser, By.id("address_first_name"));
    protected TextField lastName = new TextField(browser, By.id("address_last_name"));
    protected TextField streetAddress = new TextField(browser, By.id("address_street_address"));
    protected TextField secondaryAddress = new TextField(browser, By.id("address_secondary_address"));
    protected TextField city = new TextField(browser, By.id("address_city"));
    protected TextField zipCode = new TextField(browser, By.id("address_zip_code"));
    protected Element submit = new Element(browser, By.name("commit"));

    public void visit(String id) {
        browser.get("https://address-book-example.herokuapp.com/addresses/" + id + "/edit");
    }

    public void editAddress(AddressData address) {
        fillForm(address);
        submit.click();
    }

    public void visit(AddressData addressData) {
        visit(addressData.getId());
    }
}