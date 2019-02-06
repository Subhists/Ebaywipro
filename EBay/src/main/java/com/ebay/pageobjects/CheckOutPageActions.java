package com.ebay.pageobjects;

import com.ebay.config.AppiumBaseDriver;
import com.ebay.helper.Helper;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import java.io.IOException;

public class CheckOutPageActions extends AppiumBaseDriver {

    CheckOutPageLocators checkOutPageLocators;
    SearchResultsPageActions searchResultsPageActions;

    public CheckOutPageActions(AppiumDriver appiumDriver) throws IOException {


        this.checkOutPageLocators =new CheckOutPageLocators(appiumDriver);
        this.searchResultsPageActions = new SearchResultsPageActions(appiumDriver);
    }

    public void buyProduct() throws Exception {
        Helper.getText(checkOutPageLocators.getItemTitle());
        Helper.getText(checkOutPageLocators.getItemSubTitle());
        Helper.getText(checkOutPageLocators.getItemPrice());
        Assert.assertTrue(checkOutPageLocators.getItemTitle().equals(searchResultsPageActions.randomTitle));
        Assert.assertTrue(checkOutPageLocators.getItemSubTitle().equals(searchResultsPageActions.randomSubTitle));
        Assert.assertTrue(checkOutPageLocators.getItemPrice().equals(searchResultsPageActions.randomPrice));
        Helper.singleTap(checkOutPageLocators.getBuyNowButton());
    }



}
