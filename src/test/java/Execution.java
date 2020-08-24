import org.openqa.selenium.WebDriver;

public class Execution {
    public static void main(String[] args) {
        WebDriver driver=Driver.openBrowser("chrome","https://opensource-demo.orangehrmlive.com/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.Login("admin","admin123");
        Driver.closeBrowser();
    }
}
