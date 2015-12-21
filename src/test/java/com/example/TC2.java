package com.example;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by tkmap47 on 12/14/15.
 */
public class TC2 {

    ExtentReports extent;
    ExtentTest test;
    WebDriver driver;


    @BeforeClass
    public void M1(){
        extent = ExtentManager.Instance();
        driver = new FirefoxDriver();
    }

    @Test
    public void M3()
    {
        try{
            test = extent.startTest("ContactPage", "Verify Send button");
            driver.get("http://www.qavalidation.com/");

            Assert.assertTrue(driver.getTitle().contains("QA & Validation"));
            test.log(LogStatus.INFO, "site opened");

            driver.findElement(By.linkText("Contact!")).click();
            Thread.sleep(2000);
            WebElement Send = driver.findElement(By.id("ContactForm1_contact-form-submit"));
            if(Send.isDisplayed())
            {test.log(LogStatus.PASS, Send.getAttribute("Value")+" button Found");
                test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver, "./Send")));
            }
            else
            {test.log(LogStatus.FAIL, Send.getAttribute("Value")+" button NOT Found" );}

        }catch(Exception e){
            test.log(LogStatus.ERROR, e.getMessage());

//            test.log(LogStatus.PASS,"Adding ScreenShot",test.addScreenCapture("/Screenshots/M3.png"));

            test.log(LogStatus.FAIL,"Adding ScreenShot",test.addScreenCapture(Utility.captureScreenshot(driver,"M3")));



        }
    }

    @AfterClass
    public void tear()
    {
        extent.endTest(test);
        extent.flush();
        extent.close();
        driver.quit();
    }
}
