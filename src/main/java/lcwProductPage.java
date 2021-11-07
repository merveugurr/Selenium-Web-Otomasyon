import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class lcwProductPage extends BasePage {

    By shippingOptionLocator = By.id("filter-label");
    By productNameLocator = new By.ByCssSelector("col-xs-6");
    By showMoreButton = new By.ByClassName("lazy-load-button");
    //class="
    public lcwProductPage(WebDriver driver) {
        super(driver);
    }

    public void moreProductClick(){ find(showMoreButton).click();}

    public boolean isOnProductPage() {
        return isDisplayed(shippingOptionLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
