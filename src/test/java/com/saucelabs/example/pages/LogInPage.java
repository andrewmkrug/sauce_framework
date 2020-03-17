package com.saucelabs.example.pages;

import com.saucelabs.example.data.UserData;
import com.saucelabs.framework.elements.Element;
import com.saucelabs.framework.elements.TextField;
import com.saucelabs.framework.pages.OnPage;
import org.openqa.selenium.By;

@OnPage(path="/sign_in")
public class LogInPage extends BasePage {

    protected TextField email = new TextField(browser, By.id("session_email"));
    protected TextField password = new TextField(browser, By.id("session_password"));
    protected Element submit = new Element(browser, By.cssSelector("[data-test=submit]"));

    public void logIn(UserData userData) {
        fillForm(userData);
        submit.click();
    }
}