package com.ebay.tests;

import com.ebay.config.BaseSetUp;
import org.testng.annotations.Test;

public class PurchaseTestCases extends BaseSetUp {

    @Test
    public void testPurchaseItem() throws Exception {
        homePageActions.tapOnHamburger();
        homePageActions.tapOnSignButton();
        signInPageActions.enterUserName();
        signInPageActions.enterPassword();
        signInPageActions.tapOnSignInButton();
        homePageActions.enterSearchContent();
        searchResultsPageActions.randomItemPicking();
        checkOutPageActions.buyProduct();

    }
}
