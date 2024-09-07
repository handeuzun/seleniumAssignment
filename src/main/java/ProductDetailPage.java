import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class ProductDetailPage extends BaseMethods {

    private final By reviewsPage = By.className("yPPu6UogPlaotjhx1Qki");
    private final By filterOptions = By.className("hermes-Sort-module-Zwr_VRf_e4tZXl5J1PgT");
    private final By newReview = By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[6]/div[1]/div[1]/div[3]/div/div[2]/div/div[2]/div/div[2]");
    private final By thumpsUpComponent = By.className("hermes-ReviewCard-module-PIYjivsoZ80VfkdrlGgg");
    private final By thumpsUp = By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[6]/div[3]/div[1]/div[1]/div[2]/div[5]/div[1]/div/div[1]/div[1]/div");
    private final By pdpDetail = By.className("wcMYt7Fsyqj_QnhYGiMO");
    private final By thanksMessage = By.cssSelector(".hermes-ReviewCard-module-eFtSSTU4lYZLCnzHtzca");
    private final By favoriteButton = By.className("customerAccount-Like-2wPzH");
    private final By pdpPriceInfo = By.cssSelector("div[data-test-id='price-current-price']");
    private final By addToBasketButton = By.cssSelector("button[data-test-id='addToCart']");
    private final By closePopUpButton = By.className("checkoutui-Modal-iHhyy79iR28NvF33vKJb");
    private final By basketButton = By.cssSelector("span#shoppingCart");
    private final By basketPriceInfo = By.cssSelector("div.product_price_uXU6Q");
    private final By productsOnSearchResultPage = By.className("productListContent-zAP0Y5msy8OHn5z7T_K_");

    public ProductDetailPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    SearchPage searchPage = new SearchPage(driver);

    String pdpPrice;
    String basketPrice;

    public void tapProductDetail() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsOnSearchResultPage));
        List<WebElement> products = driver.findElements(productsOnSearchResultPage);
        ArrayList<WebElement> productList = new ArrayList<>(products);
        System.out.println("Toplam buton sayısı: " + products.size());
        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        WebElement randomProduct = productList.get(randomIndex);
        Actions actions = new Actions(driver);
        actions.moveToElement((randomProduct)).click().perform();
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
        driver.switchTo().window(tabs.get(1));
    }

    public void checkProductDetailPage(){
        Actions actions = new Actions(driver);
        WebElement scrollElement = driver.findElement(pdpDetail);
        actions.moveToElement(scrollElement).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pdpDetail));
    }

    public void tapReviewsPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewsPage));
        click(reviewsPage);
    }

    public void tapSortSelectionAndSelectNewReviews(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterOptions));
        click(filterOptions);
        click(newReview);
    }

    public void scrollToFirstReview() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement scrollElement = driver.findElement(thumpsUpComponent);
        wait.until(ExpectedConditions.visibilityOfElementLocated(thumpsUpComponent));
        actions.moveToElement(scrollElement).perform();
    }

    public void tapThumpsUpButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(thumpsUp));
        click(thumpsUp);
    }
    public void checkMessageAfterThumpsUpButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(thanksMessage));
        WebElement element = driver.findElement(thanksMessage);
        String actualText = element.getText();
        String expectedText = "Teşekkür Ederiz.";
        assertEquals(actualText, expectedText, "Success text is not expected.");
    }

    public void navigateToPdp() throws InterruptedException {
        searchPage.tapAcceptCookies();
        searchPage.clickSearchBar();
        searchPage.typeSearchTermAndSearch("iphone13");
        tapProductDetail();
    }

    public void tapLikeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteButton));
        click(favoriteButton);
    }

    public void verifyProductLiked(){

    }

    public void getPriceOfProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pdpPriceInfo));
        WebElement element = driver.findElement(pdpPriceInfo);
        pdpPrice = element.getText();
        System.out.println(pdpPrice);
        String[] parts = pdpPrice.split("TL");
        pdpPrice = parts[0].trim();
        System.out.println(pdpPrice);
    }

    public void addToBasketButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToBasketButton));
        click(addToBasketButton);
        Thread.sleep(3000);
    }

    public void checkAndCloseSuccessPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(closePopUpButton));
        click(closePopUpButton);
    }
    public void tapGoToBasket() throws InterruptedException {
        Thread.sleep(3000);
        click(basketButton);
    }

    public void checkPriceInfo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(basketPriceInfo));
        WebElement element = driver.findElement(basketPriceInfo);
        basketPrice = element.getText();
        System.out.println(basketPrice);
        String[] parts = basketPrice.split("TL");
        basketPrice = parts[0].trim();
        System.out.println(basketPrice);
        assertEquals(basketPrice, pdpPrice);
    }
}