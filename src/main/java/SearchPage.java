import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BaseMethods{

    public SearchPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    private final By acceptCookies = By.id("onetrust-accept-btn-handler");
    private final By searchButton = By.className("initialComponent-hk7c_9tvgJ8ELzRuGJwC");
    private final By searchComponent = By.cssSelector("input.searchBarContent-UfviL0lUukyp5yKZTi4k");


    public void tapAcceptCookies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookies));
        click(acceptCookies);
    }

    public void clickSearchBar() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        click(searchButton);
    }
    public void typeSearchTermAndSearch(String searchTerm){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchComponent));
        sendKeys(searchComponent,searchTerm);
        driver.findElement(searchComponent).sendKeys(Keys.RETURN);
    }
}