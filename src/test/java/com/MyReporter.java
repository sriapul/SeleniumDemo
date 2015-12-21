package com;

import org.testng.IExecutionListener;

import java.io.File;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tkmap47 on 12/15/15.
 */
public class MyReporter implements IExecutionListener {

//    public static void main(String[] args) {
//
//        MyReporter myReporter = new MyReporter();
//        myReporter.onExecutionFinish();
//    }

    public void onExecutionStart() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
        File file = new File("ExtentReports.html");
//        File arcFile = new File("ExtentReports_Old.html");
        File arcFile = new File(getCurrentTimeStamp()+"ExtentReports.html");
        System.out.println(file.renameTo(arcFile));

    }

    public  void onExecutionFinish() {


    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
