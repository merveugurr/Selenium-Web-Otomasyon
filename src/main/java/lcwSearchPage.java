import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class lcwSearchPage extends BasePage {

    By searchBoxLocator = By.id("search_input");
    By submitButtonLocator = By.id("nav-search-submit-button");

    public lcwSearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocator , text);
        click(submitButtonLocator);
    }

}
