package Pages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class lcwCartPage extends BasePage {

    public int new_quantity;
    public By orderQuantityAdder = By.className("plus");
    public By yourCartUpdatedText = By.xpath("//span[@class='rd-cart-item-price mb-15']");
    public By orderQuantityValue = By.className("item-quantity-input");
    public By removeOrderButton = By.xpath("//i[@class='fa fa-trash-o']");
    public By removeOrderFloatinButton = By.xpath("//a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']");
    public By dialogPage = By.xpath("//div[@class='modal fade delete-cart-item-modal in']");
    public By cartEmptyText = By.xpath("//p[@class='cart-empty-title']");

    public lcwCartPage(WebDriver driver) {
        super(driver);
    }

    public void removeOrder() {
        wait(removeOrderButton,30);
        click(removeOrderButton);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().activeElement();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait(dialogPage,30);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().activeElement();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(removeOrderFloatinButton);
    }

    public boolean checkCartIsEmpty() {
        wait(cartEmptyText,30);
        return isDisplayed(cartEmptyText);
    }

    public void increaseQuantity() {
        wait(orderQuantityAdder,20);
        click(orderQuantityAdder);
    }

    public boolean isOrderQuantityIncreased() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait(yourCartUpdatedText,20);
        String quantity = find(orderQuantityValue).getAttribute("value");
        new_quantity = Integer.parseInt(quantity);
        return  new_quantity == 2 ;
    }
}
