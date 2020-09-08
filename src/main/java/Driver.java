import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.io.File;
import java.io.IOException;


public class Driver {

    private static WebDriver driver=null;

    public static WebDriver openBrowser(String browser,String url){

        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
                //disabled popup
                String filepath=System.getProperty("user.dir")+"//src//main//resources//chromedriver.exe";
                ChromeOptions options=new ChromeOptions();
                 options.setBinary(filepath);
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


   public static String takeScreenshot() throws IOException {
      File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String fileName=System.getProperty("user.dir")+"\\screenshot\\ss.png";
      File destinationFile=new File(fileName);
      FileUtils.copyFile(screenshot,destinationFile);
      return fileName;
   }


}
