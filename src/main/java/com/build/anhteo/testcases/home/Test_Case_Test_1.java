package com.build.anhteo.testcases.home;

import com.build.anhteo.actions.common.BaseTest;
import com.build.anhteo.actions.pageObject.HomePageAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_Case_Test_1 extends BaseTest {
    private final String projectPath = System.getProperty("user.dir");
    WebDriver driver;
    HomePageAction homePageAction;

    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        homePageAction = new HomePageAction(driver);
    }

    @Test
    public void Test_1() {
        String parentId = driver.getWindowHandle();
        driver.get("https://demo.nopcommerce.com");
        homePageAction.clickFanPageFacebook();
        homePageAction.switchFacebook();
        homePageAction.closeAllTab(parentId);
    }

    @AfterClass
    public void afterClass() {
        homePageAction.sleepInSecond(5);
        driver.close();
        driver.quit();
    }
}
