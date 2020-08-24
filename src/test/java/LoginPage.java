import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    private By txtUserName=By.id("txtUsername"); //identified by id and storing in txtusername using By
    private By txtPassword=By.name("txtPassword");
    private By btnLogin=By.id("btnLogin");


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void Login(String userName,String password)  {

        driver.findElement(txtUserName).sendKeys(userName);//locating element by using By reference and sending data
        driver.findElement(txtPassword).sendKeys(password);
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement loginButton=wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        loginButton.click();


    }
}
