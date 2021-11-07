import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {

    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        action = new Actions(driver);
        this.wait = new WebDriverWait(driver, 20);
        if (!driver.getTitle().equals("Home Page of logged in user")) {
            throw new IllegalStateException("This is not Home Page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public WebElement find(By locator){
       return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void wait_clickible_and_click(WebElement locator){
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator,String text){
        find(locator).sendKeys(text);
    }

    public void moveToElement(By locator){
        action.moveToElement(find(locator)).build().perform();
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public void Scroll(String script){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }
    public void wait(By locator, int second){
        wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    public void wait_element(WebElement element,By locator, int second){
        wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }

    public void clear_style(String script,WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script,webElement);
    }













}
