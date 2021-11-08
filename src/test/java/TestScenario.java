import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import org.openqa.selenium.By;


public class TestScenario {

    Pages.lcwHomePage lcwHomePage;
    Pages.lcwLoginPage lcwLoginPage;
    Pages.lcwProductPage lcwProductPage;
    Pages.lcwSearchPage lcwSearchPage;
    Pages.lcwProductDetailPage lcwProductDetailPage;
    Pages.lcwCartPage lcwCartPage;
    public By productPriceFromPage = By.xpath("//div[@class='col-xs-12 price-area']/div/div/span[@class='price']");

/*
    @Test
    @Order(1)
    //@Disabled("")
    public void openBrowser() {
        Pages.lcwHomePage.navigateToUrl();
    }

    @Test
    @Order(1)
    //@Disabled("")
    public void gotoLcwWebPageTest() {
        Pages.lcwHomePage.navigateToUrl();
    }

    @Test
    public void gotoLoginPage(){
        Pages.lcwHomePage.navigateToUrl();
        Pages.lcwHomePage.kvkkPopupClose();
        Pages.lcwLoginPage.gotoLoginPage();
        Pages.lcwLoginPage.controlLoginPage();
    }

    @Test
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launch the application
        //driver.get("https://www.browserstack.com/guide/selenium-scroll-tutorial");

        //Locating element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.linkText("Daha fazla ürün gör"));

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    @Test
    public void searchProduct(){
        Pages.lcwHomePage.navigateToUrl();
        Pages.lcwHomePage.kvkkPopupClose();
        Pages.lcwLoginPage.gotoLoginPage();
        Pages.lcwLoginPage.typeUsernameAndPassword();
        Pages.lcwLoginPage.clickLoginBtn();
        Pages.lcwProductPage.searchProduct();
        Pages.lcwProductPage.controlSearchedList();
    }

    @Test
    public void gotoSecondPageAndControl(){
        Pages.lcwHomePage.navigateToUrl();
        Pages.lcwHomePage.kvkkPopupClose();
        Pages.lcwLoginPage.gotoLoginPage();
        Pages.lcwLoginPage.typeUsernameAndPassword();
        Pages.lcwLoginPage.clickLoginBtn();
        Pages.lcwProductPage.searchProduct();
        Pages.lcwProductPage.controlSearchedList();
        Pages.lcwProductPage.gotoSecondPageAndControl();
    }

    @After
    public void closeBrowser(){
        lcwAutomationPage.getDriver().quit();
    }
*/

    @Test
    @Order(1)
    public void initializeHomePage(){
       /* Pages.lcwHomePage = new Pages.lcwHomePage(driver);
        lcwProductDetailPage = new lcwProductDetailPage(driver);
        Pages.lcwProductPage = new Pages.lcwProductPage(driver);
        Pages.lcwCartPage = new Pages.lcwCartPage(driver);
        Assertions.assertTrue(Pages.lcwHomePage.isHomePage(),
                "Home page not initialized");*/
    }

    @Test
    @Order(2)
    public void loginToSite(){
        lcwHomePage.loginToTheSite();
        Assertions.assertTrue(lcwHomePage.isloginToSite(),
                "Login failed");
    }

    @Test
    @Order(3)
    //@Disabled("")
    public void searchAProduct()
    {
        lcwHomePage.ScrollDown();
        lcwProductPage.moreProductClick();
        lcwProductPage.selectProduct();
        Assertions.assertTrue(lcwProductDetailPage.isOnProductDetailPage() ,
                "Not on products page!");
    }

    @Test
    @Order(4)
    public void selectAProduct()
    {
       // productDetailPage = new ProductDetailPage(driver);
        lcwProductPage.selectProduct();
        Assertions.assertTrue(lcwProductDetailPage.isOnProductDetailPage(), "Not on Product Detail Page");

    }


    @Test
    @Order(5)
    public void addProductToCart()
    {
        lcwProductDetailPage.addToCart();
        lcwProductDetailPage.goToCart();
        Assertions.assertTrue(lcwProductDetailPage.isAllpriceSame(),
                "The prices on the product page and in the cart are not same PagePrice: " + lcwProductDetailPage.priceFromPage + " - CartPrice: " + lcwProductDetailPage.priceFromCart);

       // Assertions.assertTrue(Pages.lcwHomePage.isProductCountUp(), "Product count did not increase");

    }


    @Test
    @Order(6)
    public void goToCart()
    {
        lcwCartPage.increaseQuantity();
        Assertions.assertTrue(lcwCartPage.isOrderQuantityIncreased(),
                "Order quantity could not increased. quantity :"+ lcwCartPage.new_quantity);
       // Pages.lcwCartPage = new Pages.lcwCartPage();
       // Pages.lcwHomePage.goToCart();
        //Assertions.assertTrue(Pages.lcwCartPage.checkIfProductAdded(), "Product was not added to cart");

    }

    @Test
    @Order(7)
    public void remoteOrders(){
        lcwCartPage.removeOrder();
        Assertions.assertTrue(lcwCartPage.checkCartIsEmpty(),
                "Cart is not empty");
    }


}
