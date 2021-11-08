package Pages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class lcwProductPage extends BasePage {

    Random random = new Random();
    int Productindex = random.nextInt(48)+1;
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

    public void selectProduct() {
        getAllProducts().get(Productindex).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
