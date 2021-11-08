package Pages;

import Pages.BasePage;
import Pages.lcwSearchPage;
import Pages.lcwProductDetailPage;
import Pages.lcwLoginPage;
import Pages.lcwCartPage;
import Pages.lcwProductPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class lcwHomePage extends BasePage {

   // lcwSearchPage searchBox ;
    lcwLoginPage lcwloginpage;

    public By searchBoxLocator = By.id("search_input");
    public By submitButtonLocator = By.id("nav-search-submit-button");
    public By searchButton = By.className("searchButton");
    By cartCountLocator = By.id("spanCart");
    By cartContainerLocator = By.id("nav-cart-count-container");
    By acceptCookiesLocator = By.id("sp-cc-accept");
    public By homepageContainer = By.className("homepage-container");
    String original_price = driver.findElement(By.xpath(".//*[@id='content']/div/div[4]/div[2]/div[2]/article/div[2]/header/div/ul/li[1]/del")).getText();
    String discount_price = driver.findElement(By.xpath(".//*[@id='content']/div/div[4]/div[2]/div[2]/article/div[2]/header/div/ul/li[2]")).getText();
    public String scrollScript = "window.scrollTo(0, document.body.scrollHeight-1000)";
    public By eMailArea = By.id("LoginEmail");
    public By passTextArea = By.id("Password");
    public By LoginButton = By.id("loginLink");
    public String usereMail = "admin123@hotmail.com";
    public String loginpassword = "admin123";
    public By signInButton = By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/giris']");
    public By myAccountButton = By.xpath("//button[@class='dropdown-toggle striped-button']/span[@class='dropdown-label']");

    public lcwHomePage(WebDriver driver) {
        super(driver);
      //  searchBox = new lcwSearchPage(driver);
        action = new Actions(driver);
        lcwloginpage = new lcwLoginPage(driver);
    }

    public Boolean isHomePage(){
        return isDisplayed(homepageContainer);
    }

    public void ScrollDown(){
        Scroll(scrollScript);
    }

    public void searchBox(String text) {
        type(searchBoxLocator , text);
        click(searchButton);
    }

    public void loginToTheSite(){
        click(signInButton);
        wait(eMailArea,20);
        Pages.lcwLoginPage.Login(usereMail,loginpassword);
    }

    public Boolean isloginToSite(){
        wait(myAccountButton,20);
        moveToElement(myAccountButton);
        return isDisplayed(myAccountButton);
    }

    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }

    /* public void goToCart() {
        click(cartContainerLocator);
    }

   private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }*/

}
