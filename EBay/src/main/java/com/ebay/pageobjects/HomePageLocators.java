package com.ebay.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocators {

    public HomePageLocators(AppiumDriver driver) {
    // TODO Auto-generated constructor stub
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Main navigation, open']")
    private MobileElement hamburgerButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Search for anything']")
    private MobileElement seachEnterText;

    @FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.ebay.mobile:id/home']")
    private MobileElement signInButton;

    public MobileElement getHamburgerButton() {
        return hamburgerButton;
    }

    public void setHamburgerButton(MobileElement hamburgerButton) {
        this.hamburgerButton = hamburgerButton;
    }

    public MobileElement getSeachEnterText() {
        return seachEnterText;
    }

    public void setSeachEnterText(MobileElement seachEnterText) {
        this.seachEnterText = seachEnterText;
    }

    public MobileElement getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(MobileElement signInButton) {
        this.signInButton = signInButton;
    }
}
