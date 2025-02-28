package org.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {
                "pretty",
                "html:target/reports/index.html",
                "json:target/reports/cucumber.json"
        },
        tags = "@Test",
        glue = {"org.test.steps"}
)

public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;
    private static AppiumDriver<WebElement> driver;

    @BeforeClass
    public static void startAOSSession() throws MalformedURLException {
        System.out.println("...start aos Session");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appium:deviceName", "pixel");
        cap.setCapability("appium:platformVersion", "12");
        cap.setCapability("appium:noReset", true);
        cap.setCapability("appium:udid", "8A2X0KQH2");
        cap.setCapability("appium:appPackage", "hko.MyObservatory_v1_0");

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723"), cap);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @BeforeTest(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = {"cucumber"}, description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterTest(alwaysRun=true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

    public static AppiumDriver<WebElement> getDriver() {
        return driver;
    }

    @AfterSuite
    public void endTest() throws InterruptedException {
        TestRunner.getDriver().quit();
    }

}
