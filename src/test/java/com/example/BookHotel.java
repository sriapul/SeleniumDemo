package com.example;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class BookHotel {

    ExtentReports extent;
    ExtentTest test;
    ExtentTest parent;
    WebDriver driver;
    String currentRun;

    @BeforeClass
    public void M1(){
        extent = ExtentManager.Instance();
         parent = extent.startTest("Book Hotel Module");
//        driver = new FirefoxDriver();
    }

    @DataProvider(name = "Travel",parallel = false)
    public Object[][] createData() {

//        Object[][] retObjArr= BaseSpec.getExcelData("G:\\share\\IS\\A162\\A163\\Sridhar\\TDM Sku Validation\\Sku_11.xlsx", "Sheet1");
        Object[][] retObjArr= {{"San Francisco, California (SFO)","Chennai, India (MAA)","Search Flight from SFO to MAA"},
                                {"San José, Mineta San José Int'l, California (SJC)","Chennai, India (MAA)","Search Flight from SJC to MAA"}
                               };

        return retObjArr;
    }


    @Test(dataProvider = "Travel")
    public void BookHotel(String From, String To,String description)
    {
        try{

            driver = new FirefoxDriver();

            driver.get("http://www.aircanada.com/en/home.html");

            currentRun = description;

            test = extent.startTest("Book Hotel  Test - From = " + From + " To " + To, "Verify displayed result");

            test.log(LogStatus.INFO,"Test Started");

            new Select(driver.findElement(By.id("tripType"))).selectByVisibleText("Round-trip");

            test.log(LogStatus.PASS,"Selected TripType");

            driver.findElement(By.id("org1")).clear();

            driver.findElement(By.id("org1")).sendKeys(From);

            driver.findElement(By.xpath(".//*[@id='citylist']/div")).click();

            test.log(LogStatus.PASS, "Selected From");

            driver.findElement(By.id("dest1")).clear();

            driver.findElement(By.xpath(".//*[@id='dest1']")).sendKeys(To);

            driver.findElement(By.xpath(".//*[@id='citylist']/div")).click();

            test.log(LogStatus.PASS, "Selected To");

            driver.findElement(By.xpath(".//*[@id='departure1']")).click();

            Thread.sleep(1000);

            driver.findElement(By.xpath(" .//*[@id='c1c30']")).click();

//            driver.findElement(By.xpath(".//*[@id='departure1']")).sendKeys("26/01/2016");

            test.log(LogStatus.PASS,"Selected Departure Date");

            driver.findElement(By.xpath(".//*[@id='departure2']")).click();

            Thread.sleep(1000);

            driver.findElement(By.xpath(" .//*[@id='c1c33']")).click();

//            driver.findElement(By.xpath(".//*[@id='departure2']")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "31/01/2016");
//            driver.findElement(By.xpath(".//*[@id='departure2']")).sendKeys("31/01/2016");

            test.log(LogStatus.PASS,"Selected ReturnDate");

            if (!driver.findElement(By.xpath(".//*[@id='Flexible']/label/input")).isSelected()){

                driver.findElement(By.xpath(".//*[@id='Flexible']/label/input")).click();
            }

            driver.findElement(By.xpath(".//*[@id='searchButton']/span")).click();

            test.log(LogStatus.PASS,"Click Search Button");

            Thread.sleep(10000);

            driver.findElement(By.xpath(" .//*[@id='timeRemainingForPageExpire']")).getText().matches("([0-9]):([0-9])([0-9])");

        }catch(Exception e){
            test.log(LogStatus.ERROR, e.getMessage());
//            System.out.println(Utility.captureScreenshot(driver, currentRun.replaceAll(" ", "")));
            test.log(LogStatus.FAIL, "Adding ScreenShot", test.addScreenCapture(Utility.captureScreenshot(driver, currentRun.replaceAll(" ", ""))));
//
// test.log(LogStatus.FAIL,"Adding ScreenShot",test.addScreenCapture(Utility.captureScreenshot(driver, "M3")));
//            Assert.fail("<a href=\"/Selenium_Databinding/target/ExtentReport/SearchFlightfromSFOtoMAA.png\">Link to Failed ScreenShot</a>");
            Assert.fail("e.getMessage()");


        }
    }




    @AfterMethod
    public void tearDown(ITestResult result)

    {
        System.out.println("After test");
        System.out.println(result.getStatus());
        System.out.println(ITestResult.FAILURE);

        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL,"Adding ScreenShot",test.addScreenCapture(Utility.captureScreenshot(driver, currentRun)));
        }
        parent.appendChild(test);

//        extent.endTest(test);

        driver.quit();

    }

    @AfterClass
    public void suiteDown(){
        extent.endTest(parent);
        extent.flush();
        extent.close();
    }


    public static void main(String[] args) {

        String test = "Sridhar Jyapaul";

        System.out.println(test);


    }


}
