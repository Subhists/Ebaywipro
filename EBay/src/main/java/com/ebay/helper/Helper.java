package com.ebay.helper;



import com.ebay.config.DriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Helper {
	static AppiumDriver driver;

	static TouchAction touchAction = new TouchAction(DriverConfig.getInstance().getDriver());

	public static void singleTap(MobileElement element) {
		TouchAction touchAction = new TouchAction(DriverConfig.getInstance().getDriver());
		touchAction.tap(element).perform();
	}


    public static void scroll(MobileElement from, MobileElement to){
        touchAction.press(from).moveTo(to).release().perform();
    }


	public static Boolean verifyElementPresent(String title) {
		System.out.println(title);
		WebElement element = DriverConfig.getInstance().getDriver()
				.findElementByXPath("//android.widget.TextView[contains(@text,'" + title + "')]");
		Boolean presence = false;
		try {
			presence = element.isDisplayed();
		} catch (Exception e) {
			presence = false;
		}
		return presence;
	}

	public static Boolean verifyElementPresent(MobileElement element) {
		Boolean presence = false;
		try {
			presence = element.isDisplayed();
		} catch (Exception e) {
			presence = false;
		}
		return presence;
	}

	public void singleTap(MobileElement element, int x_axis, int y_axis) {
		touchAction.tap(element, x_axis, y_axis);
	}

	public void moveTo(MobileElement element) {
		touchAction.moveTo(element).perform();
	}

	public void moveTo(int x_axis, int y_axis) {
		touchAction.moveTo(x_axis, y_axis).perform();
	}

	public void moveTo(MobileElement element, int x_axis, int y_axis) {
		touchAction.moveTo(element, x_axis, y_axis).perform();
	}

	public void cancelAction() {
		touchAction.cancel();
	}

	public static void tapAndroidBackButton() {

		DriverConfig.getInstance().getDriver().navigate().back();

	}


	public static void waitTill(long ar) throws InterruptedException {
		Thread.sleep(ar);
	}

	public static MobileElement waitForElement(MobileElement elementToBeLoaded) {
		WebDriverWait wait = new WebDriverWait(DriverConfig.getInstance().getDriver(), 10);
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}

	public static String getText(MobileElement element) throws Exception {
		return (element.getText());

	}

	public static void enterText(MobileElement element, String input) throws Exception {
		element.sendKeys(input);
	}

	public static int getRandomIntwithinRange(int low, int high) {
		Random random = new Random();
		int randomNum = random.nextInt(high - low) + low;
		return randomNum;
	}

	public static char getRandomCharacterFromAtoZ() {
		Random random = new Random();
		char c = (char) (random.nextInt(26) + 'a');
		return c;
	}

	public static void wifiOff() throws InterruptedException {
		NetworkConnection mobileDriver = (NetworkConnection) driver;
		if (mobileDriver.getNetworkConnection() != ConnectionType.AIRPLANE_MODE) {
			// enabling Airplane mode
			mobileDriver.setNetworkConnection(ConnectionType.AIRPLANE_MODE);
		}

	}

	public static void wifiOn() throws InterruptedException {
		NetworkConnection mobileDriver = (NetworkConnection) DriverConfig.getInstance().getDriver();
		if (mobileDriver.getNetworkConnection() != ConnectionType.AIRPLANE_MODE) {
			// enabling Airplane mode
			mobileDriver.setNetworkConnection(ConnectionType.WIFI);
		}

	}


	 public static void horizontalScroll() {
		 Dimension size = DriverConfig.getInstance().getDriver().manage().window().getSize();
		  System.out.println(size);
		 int startx = (int) (size.width * 0.70);
		int  endx = (int) (size.width * 0.10);
		 int starty = size.height / 4;
		  System.out.println("Start swipe operation");
		  DriverConfig.getInstance().getDriver().swipe(startx, starty, endx, starty, 4000);
		 }

    public static String readExcel(String filePath, String fileName, String sheetName) throws IOException{

        //Create an object of File class to open xlsx file

        File file =    new File(filePath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class

            workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){


            workbook = new HSSFWorkbook(inputStream);

        }


        Sheet guru99Sheet = workbook.getSheet(sheetName);

        //Find number of rows in excel file

        int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();



        for (int i = 0; i < rowCount+1; i++) {

            Row row = guru99Sheet.getRow(i);


            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console

                System.out.print(row.getCell(j).getStringCellValue()+"|| ");

            }

            System.out.println();
        }

        return fileExtensionName;
    }

		 public static void orientationLandscape(){
        DriverConfig.getInstance().getDriver().rotate(ScreenOrientation.LANDSCAPE);
         }

    public static void orientationPortrait(){
        DriverConfig.getInstance().getDriver().rotate(ScreenOrientation.PORTRAIT);
    }


    public static void takeScreenShot(String testCaseName) throws IOException {
             TakesScreenshot takesScreenshot=(TakesScreenshot)DriverConfig.getInstance().getDriver();
             File screen=takesScreenshot.getScreenshotAs(OutputType.FILE);
             String fileName = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").format(new Date());
             FileUtils.copyFile(screen, new File("./ScreenShots/"+fileName+testCaseName+".png"));

         }


}
