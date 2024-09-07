import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;
    ProductDetailPage productDetailPage ;
    LoginPage loginPage ;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com");
        driver.navigate().refresh();
        productDetailPage = new ProductDetailPage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}