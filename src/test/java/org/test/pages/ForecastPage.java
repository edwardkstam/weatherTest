package org.test.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.test.TestRunner;

public class ForecastPage {



    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Weather Forecast\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip\"]")
    protected WebElement weatherForecastTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"9-Day Forecast\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip\"]")
    protected WebElement nineDayForecastTitle;

    public ForecastPage() {
        PageFactory.initElements(new AppiumFieldDecorator(TestRunner.getDriver()), this);
    }

    public boolean isForecastScreenDisplayed() {
        return weatherForecastTitle.isDisplayed();
    }

    public boolean isNineDayForecastDisplayed() {
        return nineDayForecastTitle.isDisplayed();
    }

    public boolean isNineDayForecastSelected() {
        return nineDayForecastTitle.isSelected();
    }

}