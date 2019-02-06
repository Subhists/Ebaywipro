package com.ebay.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageLocators {

    public SignInPageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

        @FindBy(xpath = "//android.widget.EditText[@text='Email or username']")
        private MobileElement userName;

        @FindBy(xpath = "//android.widget.EditText[@text='Password']")
        private MobileElement password;

        @FindBy(xpath = "//android.widget.Button[@text='SIGN IN']")
        private MobileElement signInButton;

    public MobileElement getUserName() {
        return userName;
    }

    public void setUserName(MobileElement userName) {
        this.userName = userName;
    }

    public MobileElement getPassword() {
        return password;
    }

    public void setPassword(MobileElement password) {
        this.password = password;
    }

    public MobileElement getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(MobileElement signInButton) {
        this.signInButton = signInButton;
    }
}
