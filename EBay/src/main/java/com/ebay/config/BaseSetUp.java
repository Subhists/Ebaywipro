package com.ebay.config;


import com.ebay.helper.Helper;
import com.ebay.pageobjects.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.net.URL;

import java.util.concurrent.TimeUnit;

public class BaseSetUp extends AppiumBaseDriver {

    protected HomePageLocators homePageLocators;
    protected HomePageActions homePageActions;
    protected SearchResultsPageLocators searchResultsPageLocators;
    protected SignInPageLocators signInPageLocators;
    protected SignInPageActions signInPageActions;
    protected SearchResultsPageActions searchResultsPageActions;
    protected CheckOutPageLocators checkOutPageLocators;
    protected CheckOutPageActions checkOutPageActions;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"automationName", "deviceName", "udid", "platformName", "platformVersion", "appActivity", "port", "systemPort", "appPackage"})
    public void setUp(String automationName,
                      String deviceName,
                      String udid,
                      String platformName,
                      String platformVersion,
                      String appActivity,
                      String port,
                      String systemPort,
            String appPackage) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("systemPort", systemPort);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        // capabilities.setCapability("app", appPath);
        driver = DriverConfig.getInstance().setDriver(new AndroidDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities));

            homePageLocators = new HomePageLocators(driver);
         homePageActions= new HomePageActions(driver);
         searchResultsPageLocators = new SearchResultsPageLocators(driver);
         signInPageLocators = new SignInPageLocators(driver);
         signInPageActions = new SignInPageActions(driver);
         searchResultsPageActions = new SearchResultsPageActions(driver);
         checkOutPageLocators =new CheckOutPageLocators(driver);
         checkOutPageActions=new CheckOutPageActions(driver);


        DriverConfig.getInstance().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        acceptAlerts();
    }


    public void acceptAlerts(){
        try{
            MobileElement alertAccept=(MobileElement) DriverConfig.getInstance().getDriver().findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
            if(Helper.verifyElementPresent(alertAccept)){
                alertAccept.click();
            }
        }catch(NoSuchElementException e){

        }
    }
        
    
    

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) throws Exception {
        if(ITestResult.FAILURE==result.getStatus()){
           Helper.takeScreenShot(result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }



    }


