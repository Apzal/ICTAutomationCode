import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        //disabled popup
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension",false);

        //Telephone interface
        //Deskphone is a class
        //Telephone phone =new Deskphone();
        //Deskphone deskphone=new Deskphone();
        WebDriver driver;
        driver=new ChromeDriver(options);//launch browser
        driver.manage().window().maximize();//maximize window
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");//navigate to url
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        driver.close();
    }
}
