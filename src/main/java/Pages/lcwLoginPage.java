package Pages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class lcwLoginPage extends BasePage {

    By eMailArea = By.id("LoginEmail");
    By passTextArea = By.id("Password");
    By LoginButton = By.id("loginLink");

    public lcwLoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String eMail, String pass) {
        driver.findElement(eMailArea).sendKeys(eMail);
        driver.findElement(passTextArea).sendKeys(pass);
        driver.findElement(LoginButton).click();
       /* type(eMailArea, eMail);
        type(passTextArea, pass);
        click(LoginButton);*/
    }

}
