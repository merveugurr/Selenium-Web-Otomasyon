import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class lcwLoginPage extends BasePage {

    public lcwLoginPage(WebDriver driver) {
        super(driver);
    }
    
    private final By email=By.id("LoginEmail");
    private final By password=By.id("Password");

    public void setEmail(String emailAsString) {
        WebElement nameSpace =(WebElement) driver.findElements(email);
        nameSpace.click();
        nameSpace.sendKeys(emailAsString);

    }
    public void setPassword(String passwordAsString) {
        WebElement nameSpace =(WebElement) driver.findElements(password);
        nameSpace.click();
        nameSpace.sendKeys(passwordAsString);
    }
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(className = "user")
    private WebElement userName;

    //Login formunu doldurmak için
    public void enterLogin(String email, String password) {
        this.email.clear();
        this.email.sendKeys(email);
        this.password.clear();
        this.password.sendKeys(password);
    }

    //Login olmak için button click
    public void submit() {
        loginButton.click();
    }

    public String getUserName(){
        return userName.getText();
    }

    public void login() {
        sleep(5);
        setText(LOGIN_EMAIL_TEXTBOX,EMAIL);
        setText(LOGIN_PASSWORD_TEXTBOX,PASSWORD);
        clickElement(SUBMIT_BUTTON);

        System.out.println(driver.getTitle());


    }

}
