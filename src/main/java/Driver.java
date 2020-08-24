import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver=null;
    public static WebDriver openBrowser(String browser,String url){

        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
                //disabled popup
                ChromeOptions options=new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension",false);
                driver=new ChromeDriver(options);//launch browser
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "ie":
                driver=new InternetExplorerDriver();
                break;
        }
        driver.manage().window().maximize();//maximize window
        driver.navigate().to(url);//navigate to url
        return driver;
    }

    public static void closeBrowser(){
        driver.close();
    }


}
