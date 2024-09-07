import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BaseMethods{

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    private final By emailText = By.id("txtUserName");
    private final By passwordText = By.id("txtPassword");
    private final By loginButton = By.id("btnLogin");

    public void verifyLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    public void login(String email, String password) throws InterruptedException {
        sendKeys(emailText,email);
        sendKeys(passwordText,password);
        click(loginButton);
        Thread.sleep(5000);
    }
}