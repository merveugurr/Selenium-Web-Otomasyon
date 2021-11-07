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
    //@Disabled("")
    public void search_a_product()
    {
       /* homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);*/
        lcwHomePage.searchBox().search("pantolon");
        Assertions.assertTrue(lcwProductPage.isOnProductPage() ,
                "Not on products page!");
    }

    @Test
    @Order(2)
    public void select_a_product()
    {
       // productDetailPage = new ProductDetailPage(driver);
        lcwProductPage.selectProduct(1);
        Assertions.assertTrue(lcwProductDetailPage.isOnProductDetailPage(), "Not on Product Detail Page");

    }


    @Test
    @Order(3)
    public void add_product_to_cart()
    {
        lcwProductDetailPage.addToCart();
        Assertions.assertTrue(lcwHomePage.isProductCountUp(), "Product count did not increase");

    }

    @Test
    @Order(4)
    public void go_to_cart()
    {
        lcwCartPage = new lcwCartPage();
        lcwHomePage.goToCart();
        Assertions.assertTrue(lcwCartPage.checkIfProductAdded(), "Product was not added to cart");

    }


}
