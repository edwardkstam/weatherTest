package org.test.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.test.TestRunner;

public class HomePage {


    @AndroidFindBy(className = "android.widget.ImageButton")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip\"]")
    protected WebElement navigateUpButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Forecast & Warning Services\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip\"]")
    protected WebElement forecastAndWarningDropDownList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"hko.MyObservatory_v1_0:id/title\" and @text=\"9-Day Forecast\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip\"]")
    protected WebElement nineDayForecastItem;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(TestRunner.getDriver()), this);
    }



    public void clickNavigateUp() {
        navigateUpButton.click();
    }

    public void clickForecastAndWarning() {
        forecastAndWarningDropDownList.click();
    }

    public void selectNineDayForecast() {
        nineDayForecastItem.click();
    }

    public boolean isHomeScreenDisplayed() {
        return navigateUpButton.isDisplayed();
    }
}