package com.reports;

import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class ExtentManager {

    public static ExtentReports Instance()
    {
        ExtentReports extent;
        String Path = "./target/ExtentReport/ExtentReport.html";
        System.out.println(Path);
        extent = new ExtentReports(Path, false);
        return extent;
    }
    public static String CaptureScreen(WebDriver driver, String ImagesPath)
    {
        TakesScreenshot oScn = (TakesScreenshot) driver;
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(ImagesPath+".jpg");
        try {
            FileUtils.copyFile(oScnShot, oDest);
        } catch (IOException e) {System.out.println(e.getMessage());}
        return ImagesPath+".jpg";
    }

}

