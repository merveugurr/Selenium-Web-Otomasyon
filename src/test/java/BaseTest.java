import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    WebDriver driver;
    String Url = "https://www.lcwaikiki.com/tr-TR/TR";
    @BeforeAll
    public void initializeDriver(){
        System.setProperty("webdriver.chromeDriver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get(Url);
    }

    @AfterAll
    public void closeDriver(){
        driver.quit();
    }


}
