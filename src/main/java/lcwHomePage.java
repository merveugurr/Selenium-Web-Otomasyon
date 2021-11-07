import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.util.Stack;

public class lcwHomePage extends BasePage {

    lcwSearchPage searchBox ;
    By cartCountLocator = By.id("spanCart");
    By cartContainerLocator = By.id("nav-cart-count-container");
    By acceptCookiesLocator = By.id("sp-cc-accept");

    String original_price = driver.findElement(By.xpath(".//*[@id='content']/div/div[4]/div[2]/div[2]/article/div[2]/header/div/ul/li[1]/del")).getText();
    String discount_price = driver.findElement(By.xpath(".//*[@id='content']/div/div[4]/div[2]/div[2]/article/div[2]/header/div/ul/li[2]")).getText();

    public lcwHomePage(WebDriver driver) {
        super(driver);
        searchBox = new lcwSearchPage(driver);
    }

    public lcwSearchPage searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0 ;
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }
}
