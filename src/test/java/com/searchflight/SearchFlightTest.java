package com.searchflight;

import com.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.Utility;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class SearchFlightTest  {

    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private Utility ul;
    public static String outputDirectory = "src/screenshot";
    ExtentReports extent;
    ExtentTest test;
    WebDriver driver;
    String currentStep;

    @BeforeClass
    public void setUp() throws Exception {
        extent = ExtentManager.Instance();
        driver = new FirefoxDriver();
        baseUrl = "http://www.aircanada.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test(description = "Search for valid flight")
    public void testValidSearch(){

        test = extent.startTest("AirCanada", "Search for valid flight");

        test.log(LogStatus.INFO, currentStep = "Test Started");

        new Select(driver.findElement(By.id("tripType"))).selectByVisibleText("Round-trip");

        test.log(LogStatus.PASS,"Selected TripType");

        driver.findElement(By.id("org1")).sendKeys("San Francisco, California (SFO)");

        test.log(LogStatus.PASS,"Selected From");

        driver.findElement(By.xpath(".//*[@id='dest1']")).sendKeys("Chennai, India (MAA)");

        test.log(LogStatus.PASS,"Selected To");

        driver.findElement(By.xpath(".//*[@id='departure1']")).sendKeys("26/01/2016");

        test.log(LogStatus.PASS,"Selected DepartureDate");

        driver.findElement(By.xpath(".//*[@id='departure2']']")).sendKeys("31/01/2016");

        test.log(LogStatus.PASS,"Selected ReturnDate");

    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String screenshot_path= Utility.captureScreenshot(driver, result.getName());
            String image= test.addScreenCapture(screenshot_path);
            test.log(LogStatus.FAIL, "Title verification", image);

        }
        extent.endTest(test);
        extent.flush();
        extent.close();
        driver.quit();

    }
}
