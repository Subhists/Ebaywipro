package com.ebay.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPageLocators {

    public CheckOutPageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_item_name']")
    private MobileElement itemTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/item_subtitle_textview']")
    private MobileElement itemSubTitle;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.ebay.mobile:id/price_or_map_layout']")
    private MobileElement itemPrice;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Buy It Now']")
    private MobileElement BuyNowButton;

    public MobileElement getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(MobileElement itemTitle) {
        this.itemTitle = itemTitle;
    }

    public MobileElement getItemSubTitle() {
        return itemSubTitle;
    }

    public void setItemSubTitle(MobileElement itemSubTitle) {
        this.itemSubTitle = itemSubTitle;
    }

    public MobileElement getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(MobileElement itemPrice) {
        this.itemPrice = itemPrice;
    }

    public MobileElement getBuyNowButton() {
        return BuyNowButton;
    }

    public void setBuyNowButton(MobileElement buyNowButton) {
        BuyNowButton = buyNowButton;
    }
}
