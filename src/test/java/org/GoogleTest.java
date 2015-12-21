package org;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by tkmap47 on 12/15/15.
 */

public class GoogleTest {
    private WebDriver driver;

    @Test
    public void googleAssertPass() {
        driver = new FirefoxDriver();
        driver.get("http://google.com");

        Boolean isFound = IsElementPresent(driver, By.cssSelector("input[value*='Google Search']"));

        Assert.assertTrue(isFound);
    }

    @Test
    public void googleAssertFail() {
        driver = new FirefoxDriver();
        driver.get("http://google.com");

        Boolean isFound = IsElementPresent(driver, By.cssSelector("input[value*='Googl Search']"));

        Assert.assertTrue(isFound);
    }

    private Boolean IsElementPresent(WebDriver driver, By by) {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) { return false; }
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
