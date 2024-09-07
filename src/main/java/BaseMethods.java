import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseMethods {

    protected WebDriver driver;

    public BaseMethods(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void sendKeys(By locator, String text){
        WebElement me = find(locator);
        if (me != null) {
            me.sendKeys(text);
        }
    }
}