package com.ebay.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPageLocators {

    public SearchResultsPageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")
    private List<MobileElement> searchList;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_item_title']")
    private List<MobileElement> itemTitle;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_item_subtitle']")
    private List<MobileElement> itemSubTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_item_price']")
    private List<MobileElement> itemPrice;

    public List<MobileElement> getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(List<MobileElement> itemPrice) {
        this.itemPrice = itemPrice;
    }

    public List<MobileElement> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<MobileElement> searchList) {
        this.searchList = searchList;
    }

    public List<MobileElement> getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(List<MobileElement> itemTitle) {
        this.itemTitle = itemTitle;
    }

    public List<MobileElement> getItemSubTitle() {
        return itemSubTitle;
    }

    public void setItemSubTitle(List<MobileElement> itemSubTitle) {
        this.itemSubTitle = itemSubTitle;
    }


}
