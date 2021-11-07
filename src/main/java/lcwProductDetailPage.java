import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class lcwProductDetailPage extends BasePage {

    By addToCartButtonLocator = By.id("pd_add_to_cart");

    public lcwProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }
}
