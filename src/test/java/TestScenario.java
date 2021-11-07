import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestScenario {

    private lcwHomePage lcwHomePage;
    private lcwLoginPage lcwLoginPage;
    private lcwProductPage lcwProductPage;
    private lcwSearchPage lcwSearchPage;
    private lcwProductDetailPage lcwProductDetailPage;
    private lcwCartPage lcwCartPage;

/*
    @Test
    @Order(1)
    //@Disabled("")
    public void openBrowser() {
        lcwHomePage.navigateToUrl();
    }

    @Test
    @Order(1)
    //@Disabled("")
    public void gotoLcwWebPageTest() {
        lcwHomePage.navigateToUrl();
    }

    @Test
    public void gotoLoginPage(){
        lcwHomePage.navigateToUrl();
        lcwHomePage.kvkkPopupClose();
        lcwLoginPage.gotoLoginPage();
        lcwLoginPage.controlLoginPage();
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
        lcwHomePage.navigateToUrl();
        lcwHomePage.kvkkPopupClose();
        lcwLoginPage.gotoLoginPage();
        lcwLoginPage.typeUsernameAndPassword();
        lcwLoginPage.clickLoginBtn();
        lcwProductPage.searchProduct();
        lcwProductPage.controlSearchedList();
    }

    @Test
    public void gotoSecondPageAndControl(){
        lcwHomePage.navigateToUrl();
        lcwHomePage.kvkkPopupClose();
        lcwLoginPage.gotoLoginPage();
        lcwLoginPage.typeUsernameAndPassword();
        lcwLoginPage.clickLoginBtn();
        lcwProductPage.searchProduct();
        lcwProductPage.controlSearchedList();
        lcwProductPage.gotoSecondPageAndControl();
    }

    @After
    public void closeBrowser(){
        lcwAutomationPage.getDriver().quit();
    }
*/

    @Test
    @Order(1)
    public void initialize_home_page(){
        lcwHomePage = new lcwHomePage(driver);
        lcwProductDetailPage = new lcwProductDetailsPage(driver);
        lcwProductsPage = new lcwProductListPage(driver);
        lcwcartPage = new lcwCartPage(driver);
        Assertions.assertTrue(lcwHomePage.isHomePage(),
                "Home page not initialized");
    }

    @Test
    @Order(2)
    public void login_to_site(){
        homePage.loginToTheSite();
        Assertions.assertTrue(homePage.isloginToSite(),
                "Login failed");
    }

    @Test
    @Order(3)
    //@Disabled("")
    public void searchAProduct()
    {
       /* homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);*/
        lcwHomePage.searchBox().search("pantolon");
        Assertions.assertTrue(lcwProductPage.isOnProductPage() ,
                "Not on products page!");
    }

    @Test
    @Order(4)
    public void selectAProduct()
    {
       // productDetailPage = new ProductDetailPage(driver);
        lcwProductPage.selectProduct(1);
        Assertions.assertTrue(lcwProductDetailPage.isOnProductDetailPage(), "Not on Product Detail Page");

    }


    @Test
    @Order(5)
    public void addProductToCart()
    {
        lcwProductDetailPage.addToCart();
        lcwProductDetailPage.goToCart();
        Assertions.assertTrue(lcwProductDetailPage.isAllpriceSame(),
                "The prices on the product page and in the cart are not same PagePrice: " + lcwProductDetailPage.parameters.priceFromPage + " - CartPrice: " + productDetailPage.parameters.priceFromCart);

       // Assertions.assertTrue(lcwHomePage.isProductCountUp(), "Product count did not increase");

    }

    @Test
    @Order(6)
    public void goToCart()
    {
        lcwCartPage.increaseQuantity();
        Assertions.assertTrue(lcwCartPage.isOrderQuantityIncreased(),
                "Order quantity could not increased. quantity :"+ lcwCartPage.new_quantity);
       /* lcwCartPage = new lcwCartPage();
        lcwHomePage.goToCart();
        Assertions.assertTrue(lcwCartPage.checkIfProductAdded(), "Product was not added to cart");
        */
    }

    @Test
    @Order(7)
    public void remoteOrders(){
        lcwCartPage.removeOrder();
        Assertions.assertTrue(lcwCartPage.checkCartIsEmpty(),
                "Cart is not empty");}


}
