package com;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class BaseTest {

    public static ExtentReports extent;
    public static ExtentTest test;
    public static String outputDirectory = "src/screenshot";

    public static ExtentReports addLogger(){

        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportsTestNG.html", false);

        return extent;

    }
}
