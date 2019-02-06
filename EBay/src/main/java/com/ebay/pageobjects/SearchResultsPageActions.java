package com.ebay.pageobjects;

import com.ebay.config.AppiumBaseDriver;
import com.ebay.helper.Helper;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class SearchResultsPageActions extends AppiumBaseDriver {

    SearchResultsPageLocators searchResultsPageLocators;

    String randomTitle;
    String randomSubTitle;
    String randomPrice;


    public SearchResultsPageActions(AppiumDriver appiumDriver) throws IOException {


        this.searchResultsPageLocators =new SearchResultsPageLocators(appiumDriver);
    }

    public void randomItemPicking() throws Exception {
        int min =0;
        int max=searchResultsPageLocators.getSearchList().size()-1;
        int randomPick = ThreadLocalRandom.current().nextInt(min, max + 1);
        Helper.scroll(searchResultsPageLocators.getSearchList().get(0),  searchResultsPageLocators.getSearchList().get(randomPick));
        Helper.singleTap(searchResultsPageLocators.getSearchList().get(randomPick));
        randomTitle=Helper.getText(searchResultsPageLocators.getItemTitle().get(randomPick));
        randomSubTitle=Helper.getText(searchResultsPageLocators.getItemSubTitle().get(randomPick));
        randomPrice=Helper.getText(searchResultsPageLocators.getItemPrice().get(randomPick));
    }






}
