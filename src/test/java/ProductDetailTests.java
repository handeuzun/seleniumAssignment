import org.testng.annotations.Test;


public class ProductDetailTests extends BaseTest{

    @Test
    public void test_NavigateToPdpReviewsPage_verifyThumpsUpFunc() throws InterruptedException {
        productDetailPage.navigateToPdp();
        productDetailPage.checkProductDetailPage();
        productDetailPage.tapReviewsPage();
        productDetailPage.tapSortSelectionAndSelectNewReviews();
        productDetailPage.scrollToFirstReview();
        productDetailPage.tapThumpsUpButton();
        productDetailPage.checkMessageAfterThumpsUpButton();
    }

    @Test
    public void test_NavigateToPdp_verifyLikeFunc() throws InterruptedException {
        productDetailPage.navigateToPdp();
        productDetailPage.checkProductDetailPage();
        productDetailPage.tapLikeButton();
        loginPage.verifyLoginPage();
        loginPage.login("test123@gmail.com","123123123");
        productDetailPage.checkProductDetailPage();
        productDetailPage.verifyProductLiked();
    }

    @Test
    public void test_NavigateToPdp_verifyProductPriceFunc() throws InterruptedException {
        productDetailPage.navigateToPdp();
        productDetailPage.checkProductDetailPage();
        productDetailPage.getPriceOfProduct();
        productDetailPage.addToBasketButton();
        productDetailPage.checkAndCloseSuccessPopUp();
        productDetailPage.tapGoToBasket();
        productDetailPage.checkPriceInfo();
    }
}