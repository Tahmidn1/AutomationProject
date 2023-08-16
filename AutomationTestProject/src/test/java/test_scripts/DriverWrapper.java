package test_scripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverWrapper {

    protected String email = "shadidulsetests@gmail.com";
    protected String password = "Test123!!";


    protected String appiumServerUrl ="valueofServerURL";




    // Initialize the ExtentReports instance
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test;

    private static WebDriver driver;
    private static String url = "https://www.google.com/";


    public void takeScreenShot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = "C:\\Users\\Owner\\Desktop\\errorFile\\error" + testName + ".png";

        try {
            // Save the screenshot to the specified path
            FileUtils.copyFile(srcFile, new File(destinationPath));
            System.out.println("Screenshot saved to: " + destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenShot(result.getName());
            test.log(Status.FAIL, "Test Failure occured"); // logging failure
        } else{
            test.log(Status.PASS,"Test Passed"); // logging test pass to report

        }

        driver.quit();
    }


    @BeforeClass
    public void beforeClass() {
        // Set up the ExtentHtmlReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\Owner\\Desktop\\testReport\\extent.html");
        extent.attachReporter(sparkReporter);

        // Set up the ExtentTest instance
        test = extent.createTest(getClass().getSimpleName());




        //setChromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Desktop\\chromedriver.exe");
        //init webdriver object
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate to the url
        driver.navigate().to(url);

    }

    @AfterClass
    public void afterClass() {
        //quit the browser
        driver.quit();
        // Flush the ExtentReports logs to the report
        extent.flush();

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getUrl() {
        return url;
    }

}
