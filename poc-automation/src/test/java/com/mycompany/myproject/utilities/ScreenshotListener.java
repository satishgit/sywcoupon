package com.mycompany.myproject.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;

import com.mycompany.myproject.common.BaseTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScreenshotListener extends TestListenerAdapter {

  @Override
  public void onTestFailure(ITestResult tr) {
	  File screenshot = new File("target" + File.separator + "screenshots" + File.separator + System.currentTimeMillis() + "_" + tr.getName() + ".png");
	    System.out.println(">>>> "+screenshot.getParent());
    if (!screenshot.exists()) {
      new File(screenshot.getParent()).mkdirs();
      try {
        screenshot.createNewFile();
      } catch (IOException e) {
    	  System.out.println(e.toString());
      }
    }
    try {
      new FileOutputStream(screenshot).write(((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES));
      Reporter.log("<a href=\"../../" + screenshot + "\" target=\"_blank\"> <img src=\"../../" + screenshot +"\" title='Failure Screenshot'  width='100' height='100' ></a>");
      

    } catch (FileNotFoundException e) {
    	System.out.println(e.toString());
    } catch (IOException e) {
    	System.out.println(e.toString());
    }
    System.out.println("Written screenshot to " + screenshot.getAbsolutePath());
  }
}

