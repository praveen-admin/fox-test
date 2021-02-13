package com.au.foxsports.test;

import com.au.foxsports.util.PropertyUtils;
import com.au.foxsports.utils.ExtentReporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public static ExtentReports report = ExtentReporting.getExtentInstance();
    public static ExtentTest test;

    @BeforeMethod
    public void initiateDriver(ITestContext context) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // TODO: study about this
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // TODO: study about this and wait
        driver.get(PropertyUtils.get("BASE_URL"));
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}
