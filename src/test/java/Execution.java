import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Execution {


    ExtentReports reports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;

    @Test
    public void Login() throws IOException {
        String path=System.getProperty("user.dir");
        reports=new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter(path+"\\report.html");
        reports.attachReporter(extentSparkReporter);
        extentTest=reports.createTest("LoginTest");
        WebDriver driver=Driver.openBrowser("ie","https://opensource-demo.orangehrmlive.com/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.Login("admin","admin123");
        extentTest.log(Status.PASS,"Login Success");
        extentTest.addScreenCaptureFromBase64String(Driver.takeScreenshot());
        reports.flush();
        Driver.closeBrowser();
    }

}
