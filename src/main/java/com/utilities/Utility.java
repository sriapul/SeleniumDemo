package com.utilities;

import java.io.File;import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class Utility
{
    public static String captureScreenshot(WebDriver driver,String screenshotName)
    {
        String imgPath = "./target/ExtentReport/"+screenshotName+".png";

        String returnPath = screenshotName+".png";
        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            File source=ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File(imgPath));

            System.out.println("Screenshot taken");

        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
        return returnPath;

    }
}
