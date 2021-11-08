package Pages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
//import Logs.Log;

public class lcwProductDetailPage extends BasePage {

    By addToCartButtonLocator = By.id("pd_add_to_cart");
    //public By addToCartButtonLocator = By.id("pd_add_to_cart");
    public By addtocartButtons = By.xpath("//div[@class='sizeAndCart']/a[@class='add-to-cart fav addToCart']");
    public By productPriceFromPage = By.xpath("//div[@class='col-xs-12 price-area']/div/div/span[@class='price']");
    public By productPriceFromCart = By.className("amount");
    public By productPrices = By.xpath("//*[@id='container']/div[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[3]/p/span");
    public By productAttribute = By.xpath("//a[@data-tracking-category='UrunDetay'][@data-tracking-label='BedenSecenekleri']");
    public By productAttributeCombine = By.xpath("//*[@id='option-size'][1]/a[@data-tracking-category='UrunDetay'][@data-tracking-label='BedenSecenekleri']");
    public By cartCountLocator = By.id("spanCart");
    public By cartContainerLocator = By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/sepetim']");
    public By cartPrice = By.xpath("//span[@class='rd-cart-item-price mb-15']");
    public By cartaddedarea = By.className("//span[@class='spanCart cart-item-count header-cart-quantity']");
    public int compareresult;
    String pagePrice;
    public String teststring;
    public String priceFromCart = "";
    public String priceFromPage = "";
    public String clearstylescript = "arguments[0].removeAttribute('style')";
   // Log log = new Log();

    public lcwProductDetailPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getAllAttributes(By by){
        return findAll(by);
    }

    public void selectAttribute(By by, int i) throws InterruptedException {
        List<WebElement> Attributes = getAllAttributes(by);
        int selectAttributeindex = (int) Math.floor(Math.random() * Attributes.toArray().length/i);
        for (WebElement webElement : Attributes) {
            clear_style(clearstylescript, webElement);
        }
        wait_element(Attributes.get(selectAttributeindex), productAttribute,20);
        wait_clickible_and_click(Attributes.get(selectAttributeindex));
    }

    public boolean isOnProductDetailPage() {
        Boolean combine = false;
        try {
            wait(addToCartButtonLocator,10);
            combine = false;
        } catch (Exception e) {}
        try {
            wait(addtocartButtons,10);
            combine = true;
        } catch (Exception e) {}
        if(combine) return isDisplayed(addtocartButtons);
        else return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        Boolean kombine = false;
        priceFromPage = find(productPrices).getText();
        priceFromPage = find(productPriceFromPage).getText();
        if(find(addtocartButtons).isEnabled()) {
            wait(addtocartButtons,7);
            click(addtocartButtons);}
        kombine = true;
        wait(productAttribute,40);
        if(!kombine)
        {
            try {
                selectAttribute(productAttribute,2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait(addToCartButtonLocator,20);
            click(addToCartButtonLocator);
        }
        else{
            try {
                selectAttribute(productAttributeCombine,4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        click(addToCartButtonLocator);
    }

    public void goToCart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(cartContainerLocator);
        wait(cartPrice,20);
        priceFromCart = find(cartPrice).getText();
    }

    public boolean isProductCountUp() {
        wait(cartaddedarea,20);
        return getCartCount() > 0 ;
    }

    private int getCartCount(){
        wait(cartaddedarea,20);
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public Boolean isAllpriceSame(){
        compareresult = priceFromCart.compareTo(priceFromPage);
        teststring = Integer.toString(compareresult);
        return compareresult == 0;
    }

    public String Getmoeys(){
        return "  Page price : " + pagePrice + "  Cart price : " + find(productPriceFromCart).getText();
    }

}
