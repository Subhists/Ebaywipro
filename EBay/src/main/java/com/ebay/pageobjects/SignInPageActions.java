package com.ebay.pageobjects;

import com.ebay.config.AppiumBaseDriver;
import com.ebay.helper.Helper;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public class SignInPageActions extends AppiumBaseDriver {

    SignInPageLocators signInPageLocators;

    public SignInPageActions(AppiumDriver appiumDriver) throws IOException {


        this.signInPageLocators =new SignInPageLocators(appiumDriver);
    }

    public void enterUserName() throws Exception {
        String username= Helper.readExcel("//resources","Data.xls", "SignIn");
        Helper.enterText(signInPageLocators.getUserName(), username);
    }

    public void enterPassword() throws Exception {
        String password= Helper.readExcel("//resources","Data.xls", "SignIn");
        Helper.enterText(signInPageLocators.getPassword(), password);
    }

    public void tapOnSignInButton() throws Exception {
        Helper.singleTap(signInPageLocators.getSignInButton());
    }

}
