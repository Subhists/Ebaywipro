package com.ebay.pageobjects;

import com.ebay.config.AppiumBaseDriver;
import com.ebay.helper.Helper;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public class HomePageActions extends AppiumBaseDriver {

    HomePageLocators homePageLocators;

    public HomePageActions(AppiumDriver appiumDriver) throws IOException {


        this.homePageLocators =new HomePageLocators(appiumDriver);
    }

    public void tapOnSignButton(){
      Helper.singleTap(homePageLocators.getSignInButton());
    }

    public void tapOnHamburger(){
        Helper.singleTap(homePageLocators.getHamburgerButton());
    }

    public void enterSearchContent() throws Exception {
        String search= Helper.readExcel("//resources","Data.xls", "Search");
        Helper.enterText(homePageLocators.getSeachEnterText(),search);
        Helper.orientationLandscape();
        Helper.orientationPortrait();
    }


}
