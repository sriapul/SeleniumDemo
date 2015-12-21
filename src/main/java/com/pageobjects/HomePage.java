package com.pageobjects;

import com.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class HomePage extends BaseTest{

    private static WebElement element = null;

    public static WebElement lnk_SignIn(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='linkSignInLogIn']"));
        return element;
    }

    public static WebElement drpdwn_TripType(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='tripType']"));
        return element;
    }

    public static WebElement txtbx_From(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='org1']"));
        return element;
    }

    public static WebElement txtbx_To(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='linkSignInLogIn']"));
        return element;
    }

    public static WebElement txtbx_DepartureDate(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='linkSignInLogIn']"));
        return element;
    }


    public static WebElement txtbx_ReturnDate(WebDriver driver){
        element = driver.findElement(By.xpath(".//*[@id='linkSignInLogIn']"));
        return element;
    }

}
